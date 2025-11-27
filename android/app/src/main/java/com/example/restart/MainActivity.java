//package com.example.restart;
//
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import androidx.annotation.NonNull;
//import io.flutter.embedding.android.FlutterActivity;
//import io.flutter.embedding.engine.FlutterEngine;
//import io.flutter.plugin.common.MethodCall;
//import io.flutter.plugin.common.MethodChannel;
//
//public class MainActivity extends FlutterActivity {
//    private static final String CHANNEL = "com.example.restart/restart";
//
//    @Override
//    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
//        super.configureFlutterEngine(flutterEngine);
//        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
//                .setMethodCallHandler(
//                        (call, result) -> {
//                            if (call.method.equals("restartApp")) {
//                                restartApp();
//                                result.success(null);
//                            } else {
//                                result.notImplemented();
//                            }
//                        }
//                );
//    }
//
//    private void restartApp() {
//        Intent intent = getBaseContext().getPackageManager()
//                .getLaunchIntentForPackage(getBaseContext().getPackageName());
//        if (intent != null) {
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                finishAndRemoveTask();
//            } else {
//                finish();
//            }
//            Runtime.getRuntime().exit(0);
//        }
//    }
//}

//package com.example.restart;
//
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import androidx.annotation.NonNull;
//import io.flutter.embedding.android.FlutterActivity;
//import io.flutter.embedding.engine.FlutterEngine;
//import io.flutter.plugin.common.MethodCall;
//import io.flutter.plugin.common.MethodChannel;
//
//public class MainActivity extends FlutterActivity {
//    private static final String CHANNEL = "com.example.restart/restart";
//
//    @Override
//    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
//        super.configureFlutterEngine(flutterEngine);
//        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
//                .setMethodCallHandler(
//                        (call, result) -> {
//                            if (call.method.equals("restartApp")) {
//                                restartApp();
//                                result.success(null);
//                            } else {
//                                result.notImplemented();
//                            }
//                        }
//                );
//    }
//
//    private void restartApp() {
//        Intent intent = new Intent("com.example.restart.RESTART_APP");
//        sendBroadcast(intent);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            finishAndRemoveTask();
//        } else {
//            finish();
//        }
//        Runtime.getRuntime().exit(0);
//    }
//}

package com.example.restart;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.example.restart/restart";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("restartApp")) {
                                restartApp();
                                result.success(null);
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }

    private void restartApp() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}


