import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bartender.viewmodel.CocktailViewModel
import com.example.bartender.ui.theme.CocktailItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun CocktailSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: CocktailViewModel = hiltViewModel()
) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search Cocktails") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.searchCocktail(searchText.text)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.getRandomCocktail()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Random")
        }

        Spacer(modifier = Modifier.height(16.dp))

        val cocktails by viewModel.cocktailList.collectAsState(initial = emptyList())
        val error by viewModel.error.collectAsState()

        if (error != null) {
            Text(
                text = "Error: $error",
                color = androidx.compose.ui.graphics.Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        } else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cocktails) { cocktail ->
                    CocktailItem(cocktail = cocktail)
                }
            }
        }
    }
}