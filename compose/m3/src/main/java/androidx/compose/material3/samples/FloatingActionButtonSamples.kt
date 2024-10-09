/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.material3.samples

import androidx.annotation.Sampled
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Sampled
@Composable
fun FloatingActionButtonSample() {
    FloatingActionButton(
        onClick = { /* do something */ },
    ) {
        Icon(Icons.Filled.Add, "Localized description")
    }
}

@Preview
@Sampled
@Composable
fun SmallFloatingActionButtonSample() {
    SmallFloatingActionButton(
        onClick = { /* do something */ },
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Localized description")
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun MediumFloatingActionButtonSample() {
    /*MediumFloatingActionButton(
        onClick = { *//* do something *//* },
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = "Localized description",
            modifier = Modifier.size(FloatingActionButtonDefaults.MediumIconSize),
        )
    }*/
}

@Preview
@Sampled
@Composable
fun LargeFloatingActionButtonSample() {
    LargeFloatingActionButton(
        onClick = { /* do something */ },
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = "Localized description",
            modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize),
        )
    }
}

@Preview
@Sampled
@Composable
fun ExtendedFloatingActionButtonTextSample() {
    ExtendedFloatingActionButton(onClick = { /* do something */ }) { Text(text = "Extended FAB") }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun SmallExtendedFloatingActionButtonTextSample() {
   /* SmallExtendedFloatingActionButton(onClick = { *//* do something *//* }) {
        Text(text = "Small Extended FAB")
    }*/
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun MediumExtendedFloatingActionButtonTextSample() {
   /* MediumExtendedFloatingActionButton(onClick = { *//* do something *//* }) {
        Text(text = "Medium Extended FAB")
    }*/
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun LargeExtendedFloatingActionButtonTextSample() {
   /* LargeExtendedFloatingActionButton(onClick = { *//* do something *//* }) {
        Text(text = "Large Extended FAB")
    }*/
}

@Preview
@Sampled
@Composable
fun ExtendedFloatingActionButtonSample() {
    ExtendedFloatingActionButton(
        onClick = { /* do something */ },
        icon = { Icon(Icons.Filled.Add, "Localized description") },
        text = { Text(text = "Extended FAB") },
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun SmallExtendedFloatingActionButtonSample() {
   /* SmallExtendedFloatingActionButton(
        onClick = { *//* do something *//* },
        icon = { Icon(Icons.Filled.Add, "Localized description") },
        text = { Text(text = "Small Extended FAB") },
    )*/
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun MediumExtendedFloatingActionButtonSample() {
    /*MediumExtendedFloatingActionButton(
        onClick = { *//* do something *//* },
        icon = {
            Icon(
                Icons.Filled.Add,
                "Localized description",
                modifier = Modifier.size(FloatingActionButtonDefaults.MediumIconSize)
            )
        },
        text = { Text(text = "Medium Extended FAB") },
    )*/
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun LargeExtendedFloatingActionButtonSample() {
    /*LargeExtendedFloatingActionButton(
        onClick = { *//* do something *//* },
        icon = {
            Icon(
                Icons.Filled.Add,
                "Localized description",
                modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize)
            )
        },
        text = { Text(text = "Large Extended FAB") },
    )*/
}

@Preview
@Sampled
@Composable
fun AnimatedExtendedFloatingActionButtonSample() {

}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun SmallAnimatedExtendedFloatingActionButtonSample() {

}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun MediumAnimatedExtendedFloatingActionButtonSample() {

}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Sampled
@Composable
fun LargeAnimatedExtendedFloatingActionButtonSample() {

}
