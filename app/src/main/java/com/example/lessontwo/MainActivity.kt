//pacote
package com.example.lessontwo

//importando classes
import android.os.Bundle
import androidx.compose.foundation.layout.Spacer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lessontwo.ui.theme.LessonTwoTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

//classe principal
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //metodo que esta exibindo a mensagem
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

//criando variaveis com valor string
data class Message(val painter: String, val body: String)

//tornando uma função composta
@Composable
fun MessageCard(msg: Message) {
    //organizando os itens horizontalmente
    Row (modifier = Modifier.padding(all = 8.dp)) {
        //imagem
        Image(
            //setando imagem na variavel 'painter'
            painter = painterResource(R.drawable.image_perfil),
            //descricao
            contentDescription = "Contact profile picture",
            //modificacao na imagem
            modifier = Modifier
                //tamanho da imagem
                .size(40.dp)
                //clipe da imagem para ter a forma de um circulo
                .clip(CircleShape)
        )

        //espaco entre a imagem e o texto
        Spacer(modifier = Modifier.width(8.dp))

        //organizando os elementos verticalmente
        Column {
            //metodo que exibe o conteudo da msg painter
            Text(text = msg.painter)
            //adicionando um espaço entre o autor e os textos da mensagem
            Spacer(modifier = Modifier.height(4.dp))
            //metodo que exibe o conteudo da msg body
            Text(text = msg.body)
        }

    }

}


