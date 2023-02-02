package com.example.tdaysapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tdaysapp.data.Datasource
import com.example.tdaysapp.model.TDays
import com.example.tdaysapp.ui.theme.TDaysAppTheme

@Composable
fun TDaysApp() {
   TDaysAppTheme() {
        TDayList(tdayList = Datasource().loadTDays())
    }

}

@Composable
fun TDayList(tdayList: List<TDays>, modifier: Modifier = Modifier) {
    Scaffold( topBar = {
        TDaysTopAppBar()
    }){
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background))
        {
            items(tdayList) { tday ->
                TDayCard(tday)
            }
        }
    }

}

@Composable
fun TDayCard(tday: TDays, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Column {
            Text(
                text = LocalContext.current.getString(tday.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
            Spacer(Modifier.weight(1f))

            Text(
                text = LocalContext.current.getString(tday.stringQuoteId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )

            Image(
                painter = painterResource(tday.imageResourceId),
                contentDescription = stringResource(tday.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            /*Text(
                text = LocalContext.current.getString(tday.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )*/
            TDayItemButton(
                expanded = expanded,
                onClick = { expanded = !expanded }
            )
            if (expanded) {
                Text(
                    text = LocalContext.current.getString(tday.stringDescId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.h6
                )
            }

        }
    }
}


@Composable
private fun TDayItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )

    }
}

@Composable
fun TDaysTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h4

        )
    }

}

@Preview
@Composable
private fun TDayCardPreview() {
    TDayCard (TDays(R.string.tc_1,R.string.tq_1,R.string.tdays1, R.drawable.photo_1))
}