### MainActivity

```kotlin
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
```

### RecyclerView Adapter

```kotlin
// 1. This RecyclerViewAdapter second argument as Function.
class MyRecyclerViewAdapter(
    private val fruitsList:List<Fruit>,
    private val clickListener:(Fruit) -> Unit)
    : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
       return fruitsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitsList.get(position), clickListener)
    }
}

class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view){

    // 2. ViewHolder bind function takes second argument as Function by passing `fruit` object.
    fun bind(fruit: Fruit, clickListener:(Fruit) -> Unit) {
        view.name_text_view.text = fruit.name
        view.setOnClickListener {
            clickListener(fruit)
        }
    }

}
```