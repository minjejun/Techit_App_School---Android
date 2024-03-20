package kr.co.lion.android26_startactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.lion.android26_startactivity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var activitySecondBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activitySecondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(activitySecondBinding.root)

        activitySecondBinding.apply {

            // Activity를 실행하기 위해 사용한 Intent는 실행된 Activity까지 전달됨.
            // Intent를 통해 전달된 데이터를 출력함
            textViewSecond.apply {
                // intent에 담겨서 전달된 데이터를 intent로 가져옴
                val data1 = intent?.getIntExtra("data1", 0)
                val data2 = intent?.getDoubleExtra("data2", 0.0)
                val data3 = intent?.getBooleanExtra("data3", false)

                text = "SecondActivity\n"
                append("data1 : ${data1}")
                append("data2 : ${data2}")
                append("data3 : ${data3}")
            }


            buttonFinishSecond.setOnClickListener {
                // 현재 Activity를 종료
                // Activity가 종ㄹ료되면 BackStack에서 Activity가 제거되고
                // 메모리에서도 제거됨( = 완전 제거 )
                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}