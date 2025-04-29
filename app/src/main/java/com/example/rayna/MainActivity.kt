package com.example.rayna
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rayna.ui.theme.RaynaTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RaynaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FirstUI(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun FirstUI(modifier: Modifier = Modifier) {
    var textValue by remember { mutableStateOf("") }
    val itemsList = remember { mutableStateListOf<String>() }
    var filteredList by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf("") }
    fun updateFilteredList(query: String) {
        filteredList = if (query.isBlank()) {
            itemsList
        } else {
            val filtered = itemsList.filter { it.contains(query, ignoreCase = true) }
            if (filtered.isEmpty()) {
                errorMessage = "No items match your search."
            } else {
                errorMessage = ""
            }
            filtered
        }
    }
    Column(
        modifier = modifier
            .padding(25.dp)
            .fillMaxSize()
    ) {
        SearchInputBar(
            textValue = textValue,
            onTextValueChange = { newTextValue ->
                textValue = newTextValue
                updateFilteredList(newTextValue)
            },
            onAddItem = {
                if (textValue.isNotBlank()) {
                    itemsList.add(textValue)
                    textValue = "" // Clear text field
                    updateFilteredList("")
                }
            }
        )
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        CardsList(filteredList)
    }
}

@Composable
fun SearchInputBar(
    textValue: String,
    onTextValueChange: (String) -> Unit,
    onAddItem: (String) -> Unit
) {
    Column {
        TextField(
            value = textValue,
            onValueChange = onTextValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter text...") }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { onAddItem(textValue) }) {
                Text("Add")
            }
        }
    }
}

@Composable
fun CardsList(items: List<String>) {
    if (items.isEmpty()) {
        Text(
            text = "No items to display.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
