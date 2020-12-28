package com.anushka.recyclerviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf(Fruit("Mango","Tom"), Fruit("Apple","Joe"),Fruit("Banana","Mark") , Fruit("Guava","Mike"),Fruit("Lemon","Mike"),Fruit("Pear","Frank"),Fruit("Orange","Joe"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.setBackgroundColor(Color.YELLOW)
        my_recycler_view.layoutManager = LinearLayoutManager(this)

        //4. send function argument which is defined on this activity to recyclerView
        my_recycler_view.adapter = MyRecyclerViewAdapter(fruitsList, {selectedFruitItem: Fruit -> listItemClicked(selectedFruitItem)})
    }

    //3. define function which takes `fruit` from adapter
    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(this@MainActivity, "Supplier name is ${fruit.supplier}", Toast.LENGTH_LONG).show()
    }

}
