package kr.co.lion.android24_permission

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.lion.android24_permission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 확인할 권한의 목록
    val permissionList = arrayOf(
        android.Manifest.permission.INTERNET,
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.READ_CONTACTS,
        android.Manifest.permission.WRITE_CONTACTS,
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // 권한을 확인한다.
        requestPermissions(permissionList, 0)

        activityMainBinding.apply {
            button.setOnClickListener {
                // 위치 사용 권한 확인
                val chk1 = checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
                if (chk1 == PackageManager.PERMISSION_GRANTED) {
                    textView.text = "위치 권한이 허용되어 있습니다."
                } else if ( chk1 == PackageManager.PERMISSION_DENIED) {
                    textView.text = "위치 권한이 허용되어 있지 않습니다."
                }

                // 연락처 권한 확인
                val chk2 = checkSelfPermission(android.Manifest.permission.READ_CONTACTS)
                if (chk2 == PackageManager.PERMISSION_GRANTED) {
                    textView.text = "연락처 권한이 허용되어 있습니다."
                } else {
                    textView.text = "연락처 권한이 허용되어 있지 않습니다."
                }
            }
        }
    }
}