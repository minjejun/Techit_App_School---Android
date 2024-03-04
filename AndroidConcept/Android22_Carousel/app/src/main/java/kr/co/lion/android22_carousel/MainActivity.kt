package kr.co.lion.android22_carousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy
import com.google.android.material.carousel.MultiBrowseCarouselStrategy
import kr.co.lion.android22_carousel.databinding.ActivityMainBinding
import kr.co.lion.android22_carousel.databinding.RowBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    // recyclerView 구성을 위한 이미지들
    val imageRes = arrayOf(
        R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
        R.drawable.image_4, R.drawable.image_5, R.drawable.image_6,
        R.drawable.image_7, R.drawable.image_8, R.drawable.image_9,
        R.drawable.image_10
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setEvent()
    }

    // RecyclerView Adapter
    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>() {

        inner class ViewHolderClass(rowBinding: RowBinding) : RecyclerView.ViewHolder(rowBinding.root) {
            val rowBinding: RowBinding

            init {
                this.rowBinding = rowBinding

                // 이미지를 눌렀을 때의 처리는 리사이클러뷰의 항목을 눌렀을 때로 처리해줌.
                rowBinding.root.setOnClickListener {
                    activityMainBinding.imageView.setImageResource(imageRes[adapterPosition])
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            val rowBinding = RowBinding.inflate(layoutInflater)

            val viewHolderClass = ViewHolderClass(rowBinding)

            return viewHolderClass
        }

        override fun getItemCount(): Int {
            // 위의 배열 개수 반환
            return imageRes.size
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowBinding.carouselImageView.setImageResource(imageRes[position])
        }
    }

    fun setEvent() {
        activityMainBinding.apply {
            // RecyclerView 세팅
            recyclerView.apply {
                // 어댑터
                adapter = RecyclerViewAdapter()

                // 레이아웃 매니저
                layoutManager = CarouselLayoutManager()


                // 아래의 레이아웃 매니저는 보여주고자 하는 이미지의 크기가 모두 같을 경우에만 사용하는 것이 좋음.
                // layoutManager = CarouselLayoutManager(MultiBrowseCarouselStrategy())
                // layoutManager = CarouselLayoutManager(HeroCarouselStrategy()) // 이미지가 꽉 채워져서 나오게 하는 메소드.
                // 크기가 작은 사진은 잘리게 됨.
                // layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy()) // 이미지 하나가 꽉 채워져서 나오게 하는
            }
        }
    }
}