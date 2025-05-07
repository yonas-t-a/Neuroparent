import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neuroparentmobileapp.R


@Composable
fun MainScreen(
    imageId: Array<Int>,
    articleTitle: Array<String>,
    articleLittleDescription: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }

    val categories = listOf("All", "ADHD", "Autism", "Dyslexia", "Anxiety", "Depression")

    val filteredItems = remember(searchQuery) {
        articleTitle.withIndex()
            .filter { it.value.contains(searchQuery, ignoreCase = true) }
            .map { it.index }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding( start = 16.dp, bottom = 0.dp, end = 16.dp, top = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back_icon),
                contentDescription = "Back",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Tips & Tricks",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp) // small space between icon and text
            )
        }
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search tips") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFE3EBF5),
                unfocusedContainerColor = Color(0xFFE3EBF5)
            )
        )
        // Horizontal Category Buttons
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(categories) { category ->   // here is the line that has a problem, red line on categories
                FilterChip(
                    text = category.toString(),
                    isSelected =  false,    // selectedCategory == category,
                    onClick = { selectedCategory = category.toString() }
                )
            }
        }

        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            val itemCount = imageId.size

            items(itemCount) {
                ColumnItem(
                    modifier,
                    painter = imageId,
                    articleTitle = articleTitle,
                    articleLittleDescription = articleLittleDescription,
                    itemIndex = it,
                    navController = navController
                )
            }
        }
    }

}


@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    articleTitle: Array<String>,
    articleLittleDescription: Array<String>,
    itemIndex: Int,
    navController: NavController
) {


    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route= "DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = articleTitle[itemIndex],
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .padding(start = 10.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                val frontText = if (articleLittleDescription[itemIndex].length > 32)
                    articleLittleDescription[itemIndex].substring(0, 33) + "..."
                else
                    articleLittleDescription[itemIndex] + "..."

                Text(
                    text = articleTitle[itemIndex],
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = frontText,
                    fontSize = 16.sp
                )
                Row {
                    Button(
                        onClick = { /* handle delete */ },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White ,
                            containerColor = Color(0xFFD58787)
                        ),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Delete Article")
                    }
                    Button(
                        onClick = { /* handle edit */ },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color(0xFFD58787)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit",
                            tint = Color.White
                        )
                    }
                }
            }

//            Icon(
//                painter = painterResource(id = R.drawable.arrow_forward_ios_24),
//                contentDescription = "Go to details",
//                modifier = Modifier
//                    .size(24.dp)
//                    .align(Alignment.CenterVertically)
//            )
//            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}

@Composable
fun FilterChip(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Surface(
        color = if (isSelected) MaterialTheme.colorScheme.primary else Color(0xFFE3EBF5),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(end = 8.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 14.sp
        )
    }
}