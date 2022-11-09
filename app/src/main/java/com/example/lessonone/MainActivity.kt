//pacote
package com.example.lessonone

//importando classes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lessonone.ui.theme.LessonOneTheme

//classe principal
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                //metodo que esta exibindo a mensagem
                MessageCard("Guys")
            }
        }
    }


//tornando uma função composta
@Composable
//função que irá exibir o texto na tela
fun MessageCard(name: String ) {
    //exibindo o texto na tela "Hello ($name : texto contido na variavel, que esta na proxima função ) !"
    Text(text = "Hello $name!")
}
//previa da mensagem
@Preview
//tornando uma função composta
@Composable
//função que o Android Studio adiciona uma janela de prévia que pode ser aberta clicando na visualização dividida
fun PreviewMessageCard() {
    //exibindo a previa da mensagem
    MessageCard("Guys")
}
