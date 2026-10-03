package com.example.hustidcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hustidcard.ui.theme.CardLabel
import com.example.hustidcard.ui.theme.CardLabelSpecial1
import com.example.hustidcard.ui.theme.CardLabelSpecial2
import com.example.hustidcard.ui.theme.CardName
import com.example.hustidcard.ui.theme.CardTitleEn
import com.example.hustidcard.ui.theme.CardTitleVi
import com.example.hustidcard.ui.theme.CardValue
import com.example.hustidcard.ui.theme.CardValueSmail
import com.example.hustidcard.ui.theme.HUSTIDCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HUSTIDCardTheme {
                StudentCard()
            }
        }
    }
}

@Composable
fun StudentCard(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(86f / 54f),
        color = Color(0xFFE5E5E5)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp,
                         top = 8.dp, bottom = 20.dp)
        ) {
            StudentCardHeader(
                modifier = Modifier.weight(14f)
                    .padding(bottom = 8.dp)
            )
            HorizontalDivider(
                thickness = 2.dp,
                color = Color(0xFFB71C1C)
            )
            StudentCardBody(
                modifier = Modifier
                    .weight(40f)
                    .padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun StudentCardHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_hust),
            contentDescription = null,
            modifier = Modifier.height(56.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .height(48.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.university_name_vi),
                style = CardTitleVi
            )
            Text(
                text = stringResource(R.string.university_name_en),
                style = CardTitleEn
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.ic_qr),
            contentDescription = null,
            modifier = Modifier.height(56.dp)
        )
    }
}

@Composable
fun StudentCardBody(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_photo),
                contentDescription = null,
                modifier = Modifier
                    .width(80.dp)
                    .padding(bottom = 4.dp)
            )
            Text(
                text = stringResource(R.string.student_id_label),
                textAlign = TextAlign.Center,
                style = CardLabel,
            )
            Text(
                text = stringResource(R.string.student_id),
                textAlign = TextAlign.Center,
                style = CardValue,
            )
        }
        Column(
            modifier = Modifier.padding(start = 16.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = stringResource(R.string.full_name_label),
                style = CardLabel
            )
            Text(
                text = stringResource(R.string.full_name),
                style = CardName
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = stringResource(R.string.date_of_birth_label),
                style = CardLabel
            )
            Text(
                text = stringResource(R.string.date_of_birth),
                style = CardValue
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = stringResource(R.string.school_name),
                style = CardValue
            )
            Text(
                text = stringResource(R.string.major_name_vi),
                style = CardValue
            )
            Text(
                text = stringResource(R.string.major_name_en),
                style = CardValueSmail
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = stringResource(R.string.valid_until_label),
                style = CardLabel
            )
            Text(
                text = stringResource(R.string.valid_until),
                style = CardValue
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .rotate(90f)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(
                        constraints.copy(
                            minWidth = constraints.minHeight,
                            maxWidth = constraints.maxHeight,
                            minHeight = constraints.minWidth,
                            maxHeight = constraints.maxWidth
                        )
                    )

                    layout(placeable.height, placeable.width) {
                        placeable.placeRelative(
                            x = (placeable.height - placeable.width) / 2,
                            y = (placeable.width - placeable.height) / 2
                        )
                    }
                }
        ) {
            Text(
                text = stringResource(R.string.student_card_vi),
                style = CardLabelSpecial1,
                maxLines = 1,
                softWrap = false
            )
            Text(
                text = stringResource(R.string.student_card_en),
                style = CardLabelSpecial2,
                maxLines = 1,
                softWrap = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    HUSTIDCardTheme {
        StudentCard()
    }
}
