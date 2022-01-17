package com.example.composescrollview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.composescrollview.ui.theme.ComposeScrollviewTheme
import com.example.composescrollview.ui.theme.Purple500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeScrollviewTheme {
                Surface(color = MaterialTheme.colors.background) {
                    VerticalHorizontalScroll()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerticalHorizontalScroll(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(alpha = 0.8F))
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            //Header text
            Text(
                text = "Header: Nestted Scrollview",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

        }
        LazyColumn{
            item {
                Text(
                    text = "Horizontal List",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
            // Horizontal ScrollView
            item {
                HorizontalCompose()
            }


            item{
                Text(
                    text = "Vertical List",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
            // Vertical ScrollView
            items(count = 10){
                VerticalComposeCard()
            }
        }
    }
}

@Composable
fun HorizontalCompose() = LazyRow{
    items(count = 10){
        Card(modifier = Modifier
            .width(110.dp)
            .height(110.dp)
            .padding(10.dp, 5.dp, 5.dp, 0.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
        )
        {
            Column(
                modifier = Modifier.padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "Puppy",
                    color= Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@Composable
fun VerticalComposeCard() = Card(
    modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(10.dp, 5.dp, 10.dp, 5.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.White),
    elevation = 5.dp
) {

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.dog),
                contentDescription ="Profile Image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Column {
                Text(
                    text = "Human's best friend dog",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                    color = Color.Gray,
                    fontSize = 12.sp)
            }
        }
    }

}




