/*
   Copyright 2023 CVS Health and/or one of its affiliates

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.cvshealth.accessibility.apps.composeaccessibilitytechniques.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvshealth.accessibility.apps.composeaccessibilitytechniques.ComposeAccessibilityTechniquesRoute
import com.cvshealth.accessibility.apps.composeaccessibilitytechniques.R
import com.cvshealth.accessibility.apps.composeaccessibilitytechniques.ui.components.BodyText
import com.cvshealth.accessibility.apps.composeaccessibilitytechniques.ui.components.BodyTextNoPadding
import com.cvshealth.accessibility.apps.composeaccessibilitytechniques.ui.theme.ComposeAccessibilityTechniquesTheme


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigationButtonClicked: (ComposeAccessibilityTechniquesRoute) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.app_name))
                }
            )
        }
    ) { contentPadding ->
        // Screen content
        val scrollState = rememberScrollState()
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            BodyTextNoPadding(textId = R.string.home_description)
            BodyText(textId = R.string.home_description_2)
            Spacer(modifier = Modifier.height(8.dp))
            NavigationCard(
                label = stringResource(R.string.text_alternatives_title),
                route = ComposeAccessibilityTechniquesRoute.TextAlternatives,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.content_grouping_title),
                route = ComposeAccessibilityTechniquesRoute.ContentGrouping,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.content_group_replacement_title),
                route = ComposeAccessibilityTechniquesRoute.ContentGroupReplacement,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.heading_semantics_title),
                route = ComposeAccessibilityTechniquesRoute.HeadingSemantics,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.list_semantics_title),
                route = ComposeAccessibilityTechniquesRoute.ListSemantics,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.interactive_control_labels_title),
                route = ComposeAccessibilityTechniquesRoute.InteractiveControlLabels,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.keyboard_types_title),
                route = ComposeAccessibilityTechniquesRoute.KeyboardTypes,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.custom_accessibility_actions_title),
                route = ComposeAccessibilityTechniquesRoute.CustomAccessibilityActions,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.accordion_title),
                route = ComposeAccessibilityTechniquesRoute.AccordionControls,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.checkbox_controls_title),
                route = ComposeAccessibilityTechniquesRoute.CheckboxControls,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(id = R.string.radio_button_groups_title),
                route = ComposeAccessibilityTechniquesRoute.RadioButtonGroups,
                onNavigationButtonClicked = onNavigationButtonClicked
            )
            NavigationCard(
                label = stringResource(R.string.switch_controls_title),
                route = ComposeAccessibilityTechniquesRoute.SwitchControls,
                onNavigationButtonClicked = onNavigationButtonClicked
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ComposeAccessibilityTechniquesTheme() {
        HomeScreen() {}
    }
}

@Composable
private fun NavigationCard(
    label: String,
    route: ComposeAccessibilityTechniquesRoute,
    modifier: Modifier = Modifier,
    onNavigationButtonClicked: (ComposeAccessibilityTechniquesRoute) -> Unit
) {
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clickable {
                onNavigationButtonClicked(route)
            },
        border = BorderStroke(2.dp, CardDefaults.outlinedCardBorder().brush)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 4.dp, top = 4.dp, bottom = 4.dp)
                .minimumInteractiveComponentSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                label,
                fontWeight = FontWeight.Medium
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_angle_right_outline),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationCardPreview() {
    ComposeAccessibilityTechniquesTheme() {
        NavigationCard(
            label = "Home",
            route = ComposeAccessibilityTechniquesRoute.Home,
            onNavigationButtonClicked = {  }
        )
    }
}
