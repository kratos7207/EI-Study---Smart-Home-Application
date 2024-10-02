# Smart Home System

Welcome to the Smart Home System project! This application simulates a smart home environment, allowing you to manage and automate various devices such as lights, thermostats, and door locks. The system is designed using several design patterns to ensure scalability, maintainability, and a clean architecture.

## Table of Contents

- [Features](#features)
- [Design Patterns Used](#design-patterns-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Logging](#logging)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Device Management**: Add, turn on/off, and schedule devices.
- **Automation**: Set triggers for automatic device control based on conditions (e.g., temperature).
- **Modular Design**: Easy to extend and add new devices or features.
- **Robust Logging**: Custom logging mechanism for tracking actions and events.
- **Exception Handling**: Graceful handling of errors and exceptions.

## Design Patterns Used

- **Observer Pattern**: Notifies devices when changes occur in the system.
- **Factory Method Pattern**: Creates different types of smart devices (lights, thermostats, door locks).
- **Proxy Pattern**: Controls access to devices for secure operations.

## Project Structure

```
SmartHomeSystem
└── src
    ├── SmartHome.java
    ├── Device.java
    ├── Light.java
    ├── Thermostat.java
    ├── DoorLock.java
    ├── DeviceFactory.java
    ├── CentralHub.java
    ├── DeviceObserver.java
    ├── DeviceProxy.java
    ├── Schedule.java
    ├── Trigger.java
    └── Logger.java
```

## Getting Started

To get a local copy up and running, follow these simple steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/smart-home-system.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd smart-home-system/src
   ```

3. **Compile the Java files**:
   ```bash
   javac *.java
   ```

4. **Run the application**:
   ```bash
   java SmartHome
   ```

## Usage

Once the application is running, you can perform the following actions:

- Add devices: Devices are automatically created using the Factory Method.
- Turn devices on/off: Use the `turnDeviceOn` and `turnDeviceOff` methods.
- Schedule devices: Use the `scheduleDevice` method to set up actions at specific times.
- Set automation triggers: Use the `addTrigger` method to define conditions for automatic actions.
- View device status: Call the `viewDeviceStatus` method to check the status of all devices.

## Logging

The system includes a logging mechanism that tracks important actions and events. Logs are printed to the console with timestamps for easy tracking.

