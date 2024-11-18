import androidx.lifecycle.ViewModel
import com.example.android_2425_vc1.data.LocalMachineDataProvider
import com.example.android_2425_vc1.model.Machine
import com.example.android_2425_vc1.screens.machines.MachinesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class MachinesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        MachinesUiState(
            machines = LocalMachineDataProvider.getMachinesData(),
            currentMachine = LocalMachineDataProvider.getMachinesData().getOrElse(0) {
                LocalMachineDataProvider.defaultMachine
            }
        )
    )
    val uiState: StateFlow<MachinesUiState> = _uiState

    fun onMachineSelected(machine: Machine) {
        _uiState.value = _uiState.value.copy(selectedMachine = machine)
    }

    fun onBackPressed() {
        _uiState.value = _uiState.value.copy(isShowingListPage = true)
    }

    fun updateCurrentMachine(selectedMachine: Machine) {
        _uiState.update {
            it.copy(currentMachine = selectedMachine)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }


    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }

    fun navigateToFilterPage() {
        _uiState.update {
            it.copy(isShowingFilterPage = true)
        }
    }

    fun updateDetailsScreenStates(machine: Machine) {
        _uiState.update {
            it.copy(
                currentMachine = machine,
                isShowingHomepage = false
            )
        }
    }
}

