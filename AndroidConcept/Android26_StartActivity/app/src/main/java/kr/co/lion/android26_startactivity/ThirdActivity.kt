package kr.co.lion.android26_startactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.lion.android26_startactivity.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    lateinit var activityThirdBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityThirdBinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(activityThirdBinding.root)

        activityThirdBinding.apply {
            textViewThird.apply {
                // intent에 담겨서 전달된 데이터를 intent로 가져옴
                val data1 = intent?.getIntExtra("data1", 0)
                val data2 = intent?.getDoubleExtra("data2", 0.0)
                val data3 = intent?.getBooleanExtra("data3", false)

                text = "ThirdActivity\n"
                append("data1 : ${data1}")
                append("data2 : ${data2}")
                append("data3 : ${data3}")
            }

            buttonFinishThird.setOnClickListener {

                // 현재 Activity가 종료되고 이전 Activity가 다시 실행될 때
                // 현재 Activity의 작업 결과를 이전 Activity가 알 수 있도록 설정해주는 메소드.
                // RESULT_OK : 작업이 잘 되었다는 의미.
                // RESULT_CANCELED : 작업이 취소 되었다는 의미. , 사용자가 Back Button을 누르면 이 값이 설정됨.
                // RESULT_FIRST_USER : 그 외의 결과를 정의할 때 사용, +1, +2, +3 식으로 해서 다양한 결과를 정의함.
                // setResult(RESULT_OK) // 액티비티간의 결과가 어떤지 나타내주는 메소드

                // 이전 Activity로 전달되는 Intent
                val resultIntent = Intent()
                resultIntent.putExtra("value1", 300)
                resultIntent.putExtra("value2", 33.33)
                resultIntent.putExtra("value3", true)

                // 작업의 결과를 설정한때 Intent도 설정해주면
                // 이전 Activity로 전달된다.
                setResult(RESULT_OK, resultIntent)

                finish()
            }
        }
    }
}