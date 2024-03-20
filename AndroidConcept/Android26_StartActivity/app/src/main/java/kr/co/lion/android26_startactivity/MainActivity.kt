package kr.co.lion.android26_startactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.lion.android26_startactivity.databinding.ActivityMainBinding
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // 계약 객체
        // 다른 Activity를 갔다 돌아왔을 때의 계약
        val contract = ActivityResultContracts.StartActivityForResult()

        // 계약 등록

        // 다른 Activity를 갔다 돌아오면 { } 내의 코드가 동작하게 됨.
        val fourthActivityLauncher = registerForActivityResult(contract) {
            // FourthActivity를 갔다 돌아왔을 때 동작할 코드를 작성.
            activityMainBinding.textViewMain.text = "FourthActivity를 갔다 돌아왔습니다.\n"

            if(it != null) {
                // 작업의 결과로 분기
                when(it.resultCode) {
                    RESULT_OK -> {
                        // setResult 메서드에 설정한 Intent 객체로 부터 데이터를 추출한다.
                        if (it.data != null) {
                            val value1 = it?.data!!.getIntExtra("value1", 0)
                            val value2 = it?.data!!.getDoubleExtra("value2", 0.0)
                            val value3 = it?.data!!.getBooleanExtra("value3", false)

                            activityMainBinding.textViewMain.append("value1 : ${value1}\n")
                            activityMainBinding.textViewMain.append("value2 : ${value2}\n")
                            activityMainBinding.textViewMain.append("value3 : ${value3}\n")
                        }
                    }
                    RESULT_CANCELED -> activityMainBinding.textViewMain.text = "작업이 취소되었습니다"
                }
            }
        }
        // 계약에 대한 내용으 Listener 내에서 사용하면 안되고 onCreate() 안에서 사용해야 함.

        activityMainBinding.apply {
            buttonStartSecond.setOnClickListener {
                // Intent 객체
                // Intext : 안드로이드 4대 구성요소를 실행하기 위해 OS에게 전달하는 요청 정보 객체
                // 실행하고자 하는 것과 관련된 모든 정보들을 담아 OS로 전달하면
                // OS가 이를 보고 실행해줌.
                // 두 번째 매개변수 : 실행하고자 하는 Activity의 자바 클래스를 지정함.
                val secondIntent = Intent(this@MainActivity, SecondActivity::class.java) // 리플렉션 사용

                // 새롭게 실행되는 Activity에 전달할 데이터가 있다면 Intent에 담아줌.
                secondIntent.putExtra("data1", 100)
                secondIntent.putExtra("data2", 11.11)
                secondIntent.putExtra("data3", true)

                // Activity 실행
                // Intent 에 등록한 클래스를 확인하여 그 클래스의 객체를 생성하고
                // onCreate 메서드를 호출함.
                // 이 때 만들어진 화면이 보이게 됨.
                // 이전으로 돌아가는 개념은 없음(안드로이드)
                startActivity(secondIntent)
            }


            buttonStartThird.setOnClickListener {
                val thirdIntent = Intent(this@MainActivity, ThirdActivity::class.java) // 리플렉션 사용

                // 새롭게 실행되는 Activity에 전달할 데이터가 있다면 Intent에 담아줌.
                thirdIntent.putExtra("data1", 200)
                thirdIntent.putExtra("data2", 22.22)
                thirdIntent.putExtra("data3", true)

                // 다른 액티비티를 실행시키고 돌아왔을 때 받을 데이터가 없다면
                // startActivity로 실행한다.
                // 만약 돌아올 때 전달 받을 데이터가 있다면...
                // 두 번째 정수 값 : requestCode라고 부름, 돌아왔을 때 이 값이 그대로 전달됨.
                // 이는 어떤 Activity를 실행했다고 돌아왔는지를 구분하기 위해 사용.
                startActivityForResult(thirdIntent, 1000)
            }

            buttonStartFourth.setOnClickListener {
                // Activity 실행
                val fourthIntent = Intent(this@MainActivity, FourthActivity::class.java)
                fourthIntent.putExtra("data1", 500)
                fourthIntent.putExtra("data2" , 55.55)
                fourthIntent.putExtra("data3", true)
                fourthActivityLauncher.launch(fourthIntent)
            }
        }
    }

    // startActivityForResult 메소드를 통해 다른 액티비티를 실행하고 돌아왔을 때 자동으로 호출되는 메소드
    // 첫 번째 매개변수 : startActivityForResult 메소드 호출 시 넣어준 두 번째 매개변수의 값.
    // -> 이것을 통해 어떤 Activity를 갔다 왔는지 확인할 수 있음.
    // 세 번째 매개변수 : 새롭게 실행된 Activity에서 setResult 메서드에 설정된 Intent
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // requestCode(어떤 Activity를 갔다 왔는가)로 분기.
        when(requestCode) {
            1000 -> {
                // resultCode(실행되었던 Activity의 작업의 결과)에 따라 분기함.
                when(resultCode) {
                    RESULT_OK -> {
                        activityMainBinding.textViewMain.text = "작업이 잘 끝났습니다.\n"

                        if(data != null){
                            val value1 = data.getIntExtra("value1", 0)
                            val value2 = data.getDoubleExtra("value2", 0.0)
                            val value3 = data.getBooleanExtra("value3", false)

                            activityMainBinding.textViewMain.append("value1 : ${value1}\n")
                            activityMainBinding.textViewMain.append("value2 : ${value2}\n")
                            activityMainBinding.textViewMain.append("value3 : ${value3}\n")
                        }
                    }
                    RESULT_CANCELED -> activityMainBinding.textViewMain.text = "작업이 취소되었습니다"
                    RESULT_FIRST_USER -> activityMainBinding.textViewMain.text = "작업의 결과가 사용자 정의 1이 되었습니다"
                    RESULT_FIRST_USER + 1 -> activityMainBinding.textViewMain.text = "작업의 결과가 사용자 정의 2가 되었습니다"
                    RESULT_FIRST_USER + 2 -> activityMainBinding.textViewMain.text = "작업의 결과가 사용자 정의 3이 되었습니다"
                }
            }
        }
    }
}