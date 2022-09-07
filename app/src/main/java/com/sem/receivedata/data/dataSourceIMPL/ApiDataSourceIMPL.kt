package com.sem.receivedata.data.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import com.sem.receivedata.data.api.ApiClient
import com.sem.receivedata.data.dataSource.ApiDataSource
import com.sem.receivedata.data.dataSource.RDDataSource
import com.sem.receivedata.data.models.Data
import com.sem.receivedata.data.models.Pagination
import com.sem.receivedata.data.models.PaginationLocalModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiDataSourceIMPL (private val dataSource: RDDataSource):
    ApiDataSource {

    override fun startMigration (context: Context) {

    val call = ApiClient.instance?.api?.loadApi()
    call?.enqueue(object: Callback <ArrayList<Data>>
   // /*<ArrayList*/<Pagination>/*>*/
     {
        override fun onResponse(
            call: Call<ArrayList<Data>>,
            //</*ArrayList<*/Pagination>/*>*/,
            response: Response<ArrayList<Data>>
           // /*<ArrayList*/<Pagination>/*>*/
        ) {

            var loadNameList: ArrayList<Data>? = null
                    // /*ArrayList<*/Pagination/*>*/? = null

           // loadNameList?.clear()

            loadNameList = (response.body() as ArrayList<Data>?)!!
                   // /*ArrayList<*/Pagination/*>*/?)!!

            for (audit in loadNameList) {

                audit.id?.let {
                    PaginationLocalModel(
                        it,

                        audit.name.toString(),
                        audit.date.toString(),
                        audit.description.toString(),
                        
                     /*   audit.image.toString(),
                        //  audit.description.toString(),
                        audit.price.toString()*/
                    )
                }?.let {
                    dataSource.insert(
                        it
                    )
                }

            }

            Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
        }

        override fun onFailure(call: Call <ArrayList<Data>>
   // /*<ArrayList*/<Pagination>/*>*/
                               , t: Throwable) {
            t.printStackTrace()
            Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

        }
    })

}

}