package com.example.practice_composebasics.ui.screen

import android.annotation.SuppressLint
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.model.onlyNumbers
import com.example.practice_composebasics.model.tipValueCalculator
import com.example.practice_composebasics.ui.MainViewModel
import com.example.practice_composebasics.ui.Preview
import com.example.practice_composebasics.ui.PreviewDark
import com.example.practice_composebasics.ui.logD
import java.text.NumberFormat

// region Composable

@Composable
fun TipTimeApp() {
    logD("TipTimeApp")

    val viewModel = viewModel<MainViewModel>()

    TipTimeScreen(
        costInputState = viewModel.costInputState,
        roundUpState = viewModel.roundUpState,
        tipPercentInputState = viewModel.tipPercentInputState,
    )
}

@Composable
private fun TipTimeScreen(
    costInputState: MutableState<String>,
    roundUpState: MutableState<Boolean>,
    tipPercentInputState: MutableState<String>,
) {
    logD("TipTimeScreen")

    val focusManager = LocalFocusManager.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            alignment = Alignment.CenterVertically,
            space = 64.dp
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        Text(
            style = MaterialTheme.typography.displayMedium,
            text = stringResource(string.tip_time_screen_calculate_tip)
        )
        InputText(
            imeAction = ImeAction.Next,
            label = stringResource(string.tip_time_screen_cost_of_service),
            onNextAction = {
                focusManager.moveFocus(
                    focusDirection = FocusDirection.Down
                )
            },
            state = costInputState
        )
        InputText(
            imeAction = ImeAction.Done,
            label = stringResource(string.tip_time_screen_how_was_the_service),
            onDoneAction = {
                focusManager.clearFocus()
            },
            state = tipPercentInputState
        )
        RoundTheTipRow(
            roundUpState = roundUpState
        )
        TipValueText(
            costInputState = costInputState,
            roundUpState = roundUpState,
            tipPercentInputState = tipPercentInputState
        )
        Spacer(
            modifier = Modifier
                .height(128.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputText(
    imeAction: ImeAction,
    label: String,
    state: MutableState<String>,
    onDoneAction: () -> Unit = {},
    onNextAction: () -> Unit = {}
) {
    logD("InputText: $label")

    var stateInput by remember { state }

    TextField(
        keyboardActions = KeyboardActions(
            onDone = { onDoneAction() },
            onNext = { onNextAction() },
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Number
        ),
        label = {
            Text(label)
        },
        onValueChange = { stateInput = it.onlyNumbers() },
        singleLine = true,
        value = stateInput,
        modifier = Modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = label
            }
    )
}

@Composable
private fun TipValueText(
    costInputState: MutableState<String>,
    roundUpState: MutableState<Boolean>,
    tipPercentInputState: MutableState<String>
) {
    logD("TipValueText")

    val costInput by remember { costInputState }
    val roundUp by remember { roundUpState }
    val tipPercentInput by remember { tipPercentInputState }

    Text(
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium,
        text = stringResource(
            string.tip_time_screen_tip_amount,
            tipValueCalculator(
                costAmount = costInput,
                roundUp = roundUp,
                tipPercent = tipPercentInput
            )
        )
    )
}

@Composable
private fun RoundTheTipRow(
    roundUpState: MutableState<Boolean>
) {
    logD("RoundTheTipRow")

    var roundUp by remember { roundUpState }

    Row(
        horizontalArrangement = Arrangement.spacedBy(
            alignment = Alignment.End,
            space = 32.dp
        ),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(stringResource(string.tip_time_screen_round_up_tip))
        Switch(
            checked = roundUp,
            onCheckedChange = { roundUp = it }
        )
    }
}

// endregion

// region Preview

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun TipTimeScreenPreview() {
    Preview {
        TipTimeScreen(
            costInputState = mutableStateOf("2000.33"),
            roundUpState = mutableStateOf(false),
            tipPercentInputState = mutableStateOf("10")
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun TipTimeScreenDarkPreview() {
    PreviewDark {
        TipTimeScreen(
            costInputState = mutableStateOf("1000.33"),
            roundUpState = mutableStateOf(true),
            tipPercentInputState = mutableStateOf("20")
        )
    }
}

// endregion
