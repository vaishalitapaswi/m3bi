package remotedemos

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

@Serializable
data class Info(val data:User1)
@Serializable
data class User1(val id:Int,val email:String,val first_name:String,val last_name:String,val avatar:String)
fun main() {
    val myURL = URL("https://reqres.in/api/users/2")
    val httpcon = myURL.openConnection()
    httpcon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
    httpcon.setRequestProperty("Content-Language", "en-US")
    httpcon.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
    val inps = InputStreamReader(httpcon.getInputStream())
    val buff = BufferedReader(inps)
    var str= ""
    var line: String?
    do {
        line = buff.readLine()
        str+= line?:""
    } while (line != null)
    println(str)
    val json = Json(JsonConfiguration.Stable)
    val obj = json.parse(Info.serializer(),str)
    println(obj)
    val user = obj.data
    println(user.first_name)
}