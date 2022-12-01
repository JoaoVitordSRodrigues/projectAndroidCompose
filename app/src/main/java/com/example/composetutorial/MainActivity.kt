//pacote
package com.example.composetutorial

//importando classes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

//classe principal
class MainActivity : ComponentActivity() {
    //Sobrescrita de método e chamada do bundle:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //metodo que esta exibindo a mensagem
        setContent {
            //Tema do material design criado no projeto:
            ComposeTutorialTheme {
                Conversation(SampleData.conversationSample)
            }
        }
    }

    //criando variaveis com valor string
    data class Message(val author: String, val body: String)

    //tornando uma função composta
    @Composable
    fun MessageCard(msg: Message) {
        //organizando os itens horizontalmente
        Row(modifier = Modifier.padding(all = 8.dp)) {
            //imagem
            Image(
                //setando imagem na variavel 'painter'
                painter = painterResource(R.drawable.image_profile),
                //descricao
                contentDescription = "Contact profile picture",
                //modificacao na imagem
                modifier = Modifier
                    //tamanho da imagem
                    .size(50.dp)
                    //clipe da imagem para ter a forma de um circulo
                    .clip(CircleShape)
                    // Borda circular e adicionando cores na borda
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            //espaco entre a imagem e o texto
            Spacer(modifier = Modifier.width(8.dp))

            // Acompanhando se a mensagem é expandida ou não nesta variável:
            var isExpanded by remember { mutableStateOf(false) }


            //organizando os elementos verticalmente
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }){
                //metodo que exibe o conteudo da msg
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall


                )
                //adicionando um espaço entre o autor e os textos da mensagem
                Spacer(modifier = Modifier.height(4.dp))

                Surface(shadowElevation = 1.dp) {
                    Text(
                        //metodo que exibe o conteudo da msg body
                        text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }

    //Anotação de criação de função que pode ter composição de componentes:
    @Composable

    //Função que processa apenas os elementos visíveis na tela:
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
    }


    //Permite visualizar as funções de composição
    @Preview

    //Permitir a visualização de uma tela clara e escura:
    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )


    //Anotação de criação de função que pode ter composição de componentes:
    @Composable

    //Método PreviewMessageCard, que puxa a composição da classe Message
    fun PreviewMessageCard() {
        ComposeTutorialTheme {
            Surface {
                MessageCard(
                    msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
                )
            }
        }
    }

    //Permite visualizar as funções de composição no Android Studio sem precisar criar e instalar o app em um emulador ou dispositvo Android:
    @Preview

    //Anotação de criação de função que pode ter composição de componentes:
    @Composable
    fun PreviewConversation() {
        ComposeTutorialTheme {
            Conversation(SampleData.conversationSample)
        }
    }

}

