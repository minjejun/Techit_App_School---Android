package kr.co.lion.android15_imageview

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable
import kr.co.lion.android15_imageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply {
            button.setOnClickListener {
                // 웹 서버가 제공하는 이미지를 뷰여주고자 할 때 사용
                // imageView2.setImageURI(사이트의 주소를 관리하는 URI 객체)

                // 프로젝트의 res/drawable, res/mipmap 폴더에 있는 이미지를 보여주고자 할 때 사용.
                // imageView2.setImageResource(R.drawable.img_android) // 정수형 변수
                // 파일 이름을 구분하기 위한 것으로 생각.
                
                // Bitmap : Bitmap 타입의 데이터를 관리하는 이미지 객체
                // Bitmap 데이터 타입 : 각 픽셀의 색상 값이 저장되어 있는 상태.
                // Drawable : Bitmap 타입의 데이터를 관리하는 이미지 객체
                // Bitmap이나 Drawable 객체로 만들어 쓰는 이미지는 외부에 존재하는 (res 폴더 내부가 아닌 곳에 존재하는)
                // 이미지를 가져다 사용할 때 이 타입의 객체로 만들어 사용.
                // Bitmap과 drawable 둘 다 제공하는 작업인 경우엔 Bitmap을 추천.
                // 아이콘 제외하고는 전부 Bitmap으로 준비하면 됨.
                // 아이콘만 Vector 방식으로 작성하면 됨.
                val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
                imageView2.setImageBitmap(bitmap)

                val drawable = bitmap.toDrawable(resources)
                imageView2.setImageDrawable(drawable)
            }
        }
    }
}