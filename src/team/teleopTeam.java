package org.firstinspires.ftc.teamcode.IntoTheDeep24_25.teleop;

import static com.qualcomm.robotcore.util.Range.clip;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.TemplateJanx;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This template provides a framework for recording and controlling robot movements during TeleOp mode.
 * Teams should fill in the specific motor and servo logic to suit their robot's configuration.
 *
 * @Author Capital Robotics FTC 14251
 * @version 1.0.0
 *
 */



@TeleOp(name = "TeleOpTemplate")
public class TeleOpTemplate extends OpMode {
    private DcMotorEx frontRight, backRight, frontLeft, backLeft, armMotor;
    private Servo claw;
    private JSONArray movementLog; 

    // Arm positions
    private final int armUpPosition = 20;
    private final int armDownPosition = 150;
    private boolean armFlag = false; 
    private boolean lastAState = false;

    @Override
    public void init() {
        TemplateJanx janx = new TemplateJanx(hardwareMap);
        janx.wheelInit("frontRight", "backRight", "backLeft", "frontLeft");
        frontLeft = janx.fl;
        frontRight = janx.fr;
        backRight = janx.br;
        backLeft = janx.bl;

        armMotor = hardwareMap.get(DcMotorEx.class, "arm");
        claw = hardwareMap.get(Servo.class, "claw");

        armMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setTargetPosition(armDownPosition);
        armMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        movementLog = new JSONArray();
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // Teams should fill in the specific logic for mecanum drive, claw control, and arm control.
        // Example method calls:
        // mecanumDrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        // controlClaw();
        // controlArm();

        recordMovement();

        telemetry.addData("Arm Position", armMotor.getCurrentPosition());
        telemetry.addData("Claw Position", claw.getPosition());
        telemetry.update();
    }

    @Override
    public void stop() {
        try (FileWriter file = new FileWriter("/sdcard/FIRST/movementLog.json")) {
            file.write(movementLog.toString());
            telemetry.addData("Status", "Movements saved to /sdcard/FIRST/movementLog.json");
        } catch (IOException e) {
            telemetry.addData("Error", "Failed to save movements: " + e.getMessage());
        }
        telemetry.update();
    }

    /**
     * Records the current state of the robot's motors and servos.
     * Teams should fill in the specific logic for recording the motor and servo states.
     */
    private void recordMovement() {
        try {
            JSONObject movement = new JSONObject();
            // Example:
            // movement.put("frontLeftVelocity", frontLeft.getVelocity());
            // movement.put("frontRightVelocity", frontRight.getVelocity());
            // movement.put("backLeftVelocity", backLeft.getVelocity());
            // movement.put("backRightVelocity", backRight.getVelocity());
            // movement.put("armPosition", armMotor.getCurrentPosition());
            // movement.put("clawPosition", claw.getPosition());
            movementLog.put(movement);
        } catch (Exception e) {
            telemetry.addData("Error", "Failed to record movement");
        }
    }

    /**
     * Teams should implement the mecanum drive logic here.
     * @param LSY Left stick Y-axis
     * @param LSX Left stick X-axis
     * @param RSX Right stick X-axis
     */
    private void mecanumDrive(double LSY, double LSX, double RSX) {
        // Implement mecanum drive logic
    }

    /**
     * Teams should implement the claw control logic here.
     */
    private void controlClaw() {
        // Implement claw control logic
    }

    /**
     * Teams should implement the arm control logic here.
     */
    private void controlArm() {
        // Implement arm control logic
    }
}
