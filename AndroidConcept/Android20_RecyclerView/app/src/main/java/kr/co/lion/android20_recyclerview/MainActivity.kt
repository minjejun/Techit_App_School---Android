package kr.co.lion.android20_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import kr.co.lion.android20_recyclerview.databinding.ActivityMainBinding


// AdapterView : 무한개의 항목을 보여주는 목적으로 사용하는 뷰들
// Adapter를 사용하기 때문에 AdapterView라고 부름

// Adapter : View를 구성하기 위해 필요한 정보를 가지고 있는 요소.

class MainActivity : AppCompatActivity() {

    // 이미지의 id
    val imageRes = arrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
        R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    )

    // 문자열1
    val textData1 = arrayOf(
        "토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"
    )

    // 문자열2
    val textData2 = arrayOf(
        "탈락", "진출", "탈락", "진출", "탈락", "진출", "진출", "진출"
    )

    lateinit var activityMainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply {
            // 어뎁터 객체 생성
            val recyclerViewAdapter = RecyclerViewAdapter()
            // 어뎁터를 적용해준다.
            recyclerView.adapter = recyclerViewAdapter
            // RecyclerView 의 항목을 보여줄 방식을 결정
            // 위에서 아래 방향
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            // RecyclerView Decoration
            val deco = MaterialDividerItemDecoration(this@MainActivity, MaterialDividerItemDecoration.VERTICAL)
//            deco.dividerInsetStart = 50 - 좌측 여백
//            deco.dividerInsetEnd = 50 - 우측 여백
            recyclerView.addItemDecoration(deco)

        }


        // 전체 항목의 개수
        // 항목마다의 모양
        // 어떤 데이터를 세팅할 것인지
    }

    // Adapter
    // RecyclerView 구성을 위해 필요한 코드들이 작성되어 있음.
    // 1. 클래스를 작성
    // class ReCyclerViewAdapter {

    // }

    // 2. ViewHolder 클래스를 작성
    // ViewHolder : View의 id를 가지고 있는 요소
    // 3. adapter 클래를 Adapter 를 상속받게 구현해준다.
    // 필요한 메서드들을 구현해준다.
    inner class ReCyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>() {

        // ViewHolder
        inner class ViewHolderClass(rowBinding: RowBinding) : RecyclerView.ViewHolder(rowBinding.root) {
            var rowBinding : RowBinding

            init {
                this.rowBinding = rowBinding

                // 현재 항목을 누르면 반응하는 리스너
                // adapterPosition 프로퍼티 : 항목의 순서값
                // 사용자가 터치한 항목이 몇 번째 항목인가로 사용.
                this.rowBinding.root.setOnClickListener {
                    activityMainBinding.textView.text = "선택한 항목 : ${textData1[adapterPosition]}"
                }
                // View의 가로 길이는 최대 크기로 맞춰줌.
                this.rowBinding.root.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }

        // ViewHolder 객체를 생성하여 반환함
        // 새롭게 항목이 보여질 때 재사용 가능한 항목이 없다면 이 메소드를 호출.
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolderClass {
           // viewBinding
            val rowBinding = RowBinding.inflate(layoutInflater)

            val viewHolderClass = ViewHolderClass(rowBinding)

            return viewHolderClass
        }

        // RecyclerView를 통해 보여줄 항목 전체의 개수를 반환.
        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowBinding.imageViewRow.setImageResource(imageRes[position])
            holder.rowBinding.textViewRow1.text = textData1[position]
            holder.rowBinding.textViewRow2.text = textData2[position]
        }

        // 보여줄 항목의 전체 개수 반환. 정수 값을 가지고 파악.
        override fun getItemCount(): Int {
            return imageRes.size
        }
    }
}