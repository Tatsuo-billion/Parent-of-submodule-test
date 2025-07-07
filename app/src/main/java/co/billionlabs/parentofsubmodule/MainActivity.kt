package co.billionlabs.parentofsubmodule

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.billionlabs.mylibrary1.DeviceHandler1
import co.billionlabs.mylibrary1.VibrationController1
import co.billionlabs.mylibrary1.SensorDataReceiver1
import co.billionlabs.parentofsubmodule.ui.theme.ParentOfSubmoduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        val device = DeviceHandler1()
        val vibration = VibrationController1(this)
        val registeredSet = device.registeredDeviceSet
        Log.d("parameter", registeredSet.toString())
        
        setContent {
            ParentOfSubmoduleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParentOfSubmoduleTheme {
        Greeting("Android")
    }
}