[![](https://jitpack.io/v/CapitalRobotics/AutoTrack.svg)](https://jitpack.io/#CapitalRobotics/AutoTrack)


# AutoTrack
AutoTrack is a comprehensive system for FTC robots that allows drivers to record precise movements during TeleOp and replay them seamlessly in Autonomous mode.

## Overview
This system enables your FTC robot to **record movements and actions during TeleOp** and **replay them accurately in Autonomous mode**. By capturing all driver-controlled commands and re-executing them in Auto, you can replicate complex tasks without the need for extensive manual programming.


## Get Started
To get a Git project into your build:

**Step 1.**  Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```gradle
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency
```gradle
	dependencies {
	        implementation 'com.github.CapitalRobotics:AutoTrack:Tag'
	}
```



---

## Key Features
### 1. Recording Script (TeleOp)
- Captures:
  - Drivetrain movements (velocities, directions)
  - Arm and claw positions
  - Other actuator states
- Saves:
  - Commands in real-time with precise timestamps
  - A sequence file (`recorded_actions.json`) that stores all recorded actions for replay.

### 2. Replay Script (Autonomous)
- Reads the recorded action sequence from `recorded_actions.json`.
- Replays:
  - All drivetrain, arm, and claw actions in the exact order and timing as originally recorded.
- Ensures:
  - Consistent and repeatable execution of complex routines.

---

## Workflow
### **Step 1: Record in TeleOp**
1. Drivers control the robot during TeleOp using their gamepads.
2. The robot records all movements and actions to `recorded_actions.json` in real-time.
3. Save the file after TeleOp ends for use in Autonomous.

### **Step 2: Replay in Auto**
1. The replay script reads `recorded_actions.json`.
2. Commands are executed in sequence, mimicking the original performance from TeleOp.
3. Complex tasks, such as navigating the field, manipulating game elements, or performing scoring actions, are replayed precisely.

---

## Benefits
- **Rapid Autonomous Development**: Record once, replay many times. Perfect for iterative testing.
- **Accuracy**: Replicates driver-controlled movements with minimal manual programming.
- **Flexibility**: Adapts to any sequence of tasks as long as the recording is saved.
