package com.xxh.learn.fragment.sample.demo

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.fragment
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

/**
 * 代码封装和类型安全
 */

@Serializable
internal data class ContactDetails(val id: String)

@Serializable
internal object Contacts

fun NavGraphBuilder.contactsDestination() {
    fragment<ContactsFragment, Contacts>(){

    }
}


fun NavGraphBuilder.contactDetails() {

    fragment<ContactDetailsFragment, ContactDetails>(){

    }

}

fun NavController.navigateToContactDetails(id: String) {
    navigate(route = ContactDetails(id = id))
}


/**
 * compose相关实现
 */
/*fun NavGraphBuilder.contactsDestinationCompose() {
    composable<Contacts> { ContactsScreen(ContactsUiState()){

    } }
}

// Displays a list of contacts
@Composable
internal fun ContactsScreen(
    uiState: ContactsUiState,
    onNavigateToContactDetails: (contactId: String) -> Unit
) { }


// Displays the details for an individual contact
@Composable
internal fun ContactDetailsScreen(contact: ContactDetails) {  }


// Adds contacts destination to `this` NavGraphBuilder
fun NavGraphBuilder.contactsDestination(
    // Navigation events are exposed to the caller to be handled at a higher level
    onNavigateToContactDetails: (contactId: String) -> Unit
) {
    composable<Contacts> {
        // The ViewModel as a screen level state holder produces the screen
        // UI state and handles business logic for the ConversationScreen
        val viewModel: ContactsViewModel = hiltViewModel()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle()
        ContactsScreen(
            uiState.value,
            onNavigateToContactDetails
        )
    }
}

fun NavGraphBuilder.contactDetailsDestination() {
    composable<ContactDetails> { navBackStackEntry ->
        ContactDetailsScreen(contact = navBackStackEntry.toRoute())
    }
}

@Composable
fun MyApp() {
   // ...
    val navController= rememberNavController()
    NavHost(navController, startDestination = Contacts) {
        contactsDestination(onNavigateToContactDetails = { contactId ->
            navController.navigateToContactDetails(id = contactId)
        })
        contactDetailsDestination()
    }
}*/








