package remotedemos

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.net.URL
@Serializable
data class User(val userId:Int, val id:Int,val title:String,val completed:Boolean)
fun main() {
    println("Remote Call")
    val url = URL("https://jsonplaceholder.typicode.com/todos/1")
    val contentype = url.getContent().toString()
    println(contentype)
    val jsontext = url.readText().toString()
    println(jsontext)
    val json = Json(JsonConfiguration.Stable)
    val obj = json.parse(User.serializer(),jsontext)
    println(obj)
    println(obj.title)

}