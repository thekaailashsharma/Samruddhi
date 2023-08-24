package app.agro.samruddhi.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.datastore: DataStore<Preferences> by preferencesDataStore("pref")

class DataStore(private val context: Context) {
    companion object {
        val currentLocale = stringPreferencesKey("currentLocale")
        val userType = stringPreferencesKey("userType")
    }

    val getLocale: Flow<String> = context.datastore.data.map {
        it[currentLocale] ?: "en"
    }
    val getUserType: Flow<String> = context.datastore.data.map {
        it[userType] ?: ""
    }

    suspend fun saveLocale(locale: String) {
        context.datastore.edit {
            it[currentLocale] = locale
        }
    }

    suspend fun saveUserType(type: String) {
        context.datastore.edit {
            it[userType] = type
        }
    }
}
