// Target Interface

interface MediaPlayer {

    void play(String audioType, String fileName);
}

// Adaptee
class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Playing audio: " + fileName + " of type: " + audioType);
    }
}

// Adapter
class MediaAdapter implements MediaPlayer {

    private AudioPlayer audioPlayer;

    public MediaAdapter() {
        audioPlayer = new AudioPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3") || audioType.equalsIgnoreCase("mp4")) {
            audioPlayer.play(audioType, fileName);
        } else {
            System.out.println("Invalid audio type: " + audioType);
        }
    }
}

// Example usage
public class AdapterPatternDemo {

    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();
        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
        player.play("avi", "movie.avi"); // Invalid type
    }
}
