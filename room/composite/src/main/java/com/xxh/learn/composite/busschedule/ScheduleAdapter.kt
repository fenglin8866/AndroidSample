package com.xxh.learn.composite.busschedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xxh.learn.composite.R
import com.xxh.learn.composite.database.schedule.Schedule

class ScheduleAdapter(private val dataSet: List<Schedule>) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    private var callback: ((String) -> Unit)? = null

    private var callback2: ((Int, String) -> Unit)? = null

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the ViewHolder's View
        val stopName: TextView = view.findViewById(R.id.stop_name)
        val arrivalTime: TextView = view.findViewById(R.id.arrival_time)
    }

    fun setItemClickCallback(itemCallback: (String) -> Unit) {
        callback = itemCallback
    }

    fun setItemClickCallback2(itemCallback2: (Int, String) -> Unit) {
        callback2 = itemCallback2
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_schedule_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val schedule = dataSet[position]
        viewHolder.stopName.text = schedule.stopName
        viewHolder.arrivalTime.text = schedule.arrivalTime.toString()
        /*viewHolder.textView.text = dataSet[position]
        viewHolder.textView.setOnClickListener {
            callback?.let { it -> it(dataSet[position]) }
            callback2?.let { it -> it(position, dataSet[position]) }
        }*/

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
