package com.example.easyfinancing.ui.adapters.card

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.easyfinancing.R
import com.example.easyfinancing.ui.adapters.extract.AdapterCombinedEx
import com.example.easyfinancing.ui.models.card.CardBill
import com.example.easyfinancing.ui.models.extract.MovDate
import com.example.easyfinancing.ui.models.extract.Movimentation

class CardAdapter(val context: Context, val list : MutableList<CardBill>) :
    Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycle_card_item, parent,false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class CardViewHolder(itemView: View) : ViewHolder(itemView){
        val recyclerView : RecyclerView
        val movimentation : MutableList<Any> = mutableListOf()

        init {
            recyclerView = itemView.findViewById(R.id.card_movimentation)
            recyclerView.layoutManager = LinearLayoutManager(itemView.context)
            recyclerView.setHasFixedSize(true)
            movimentation.add(MovDate("Terça, 04 jun. 2024"))
            movimentation.add(Movimentation(0, "Terça, 04 jun. 2024", R.drawable.arrow_drop_up, "Teste", "Teste", "R$ 0,00"))
            val cardMovsAdapter = AdapterCombinedEx(itemView.context, movimentation)
            recyclerView.adapter = cardMovsAdapter
        }
        fun bind(card: CardBill){

        }
    }
}