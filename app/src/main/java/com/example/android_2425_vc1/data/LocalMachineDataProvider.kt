package com.example.android_2425_vc1.data

import com.example.android_2425_vc1.R
import com.example.android_2425_vc1.model.Machine
import com.example.android_2425_vc1.model.MachineCategory
import com.example.android_2425_vc1.model.Option
import com.example.android_2425_vc1.model.OptionCategory

object LocalMachineDataProvider {
    val defaultMachine = getMachinesData()[0]

    fun getMachinesData(): List<Machine> {
        return listOf(
            Machine(
                id = 1,
                serialNumber = "SN001",
                name = "Caterpillar 320D",
                category = MachineCategory.RUPSMACHINE,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.excavator_caterpillar_description,
                brochureText = R.string.excavator_caterpiller_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            ),
            Machine(
                id = 2,
                serialNumber = "SN002",
                name = "Komatsu PC210LC",
                category = MachineCategory.MOBIELE_KRANEN,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.excavator_komatsu_description,
                brochureText = R.string.excavator_komatsu_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            ),
            Machine(
                id = 3,
                serialNumber = "SN003",
                name = "John Deere 670G",
                category = MachineCategory.BULLDOZER,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.bulldozer_john_deere_description,
                brochureText = R.string.bulldozer_john_deere_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            ),
            Machine(
                id = 4,
                serialNumber = "SN004",
                name = "Hitachi ZX350LC",
                category = MachineCategory.GRONDVERDRINGER,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.excavator_hitachi_description,
                brochureText = R.string.excavator_hitachi_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            ),
            Machine(
                id = 5,
                serialNumber = "SN005",
                name = "Volvo EC950F",
                category = MachineCategory.WIELLOADER,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.wheel_loader_volvo_description,
                brochureText = R.string.wheel_loader_volvo_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            ),
            Machine(
                id = 6,
                serialNumber = "SN006",
                name = "Liebherr LTM 1060-3.1",
                category = MachineCategory.KRAAN,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.crane_liebherr_description,
                brochureText = R.string.crane_liebherr_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            ),
            Machine(
                id = 7,
                serialNumber = "SN007",
                name = "Case CX300D",
                category = MachineCategory.TRACER,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.excavator_case_description,
                brochureText = R.string.excavator_case_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            ),
            Machine(
                id = 8,
                serialNumber = "SN008",
                name = "JCB 540-170",
                category = MachineCategory.TELESCOOP,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.telehandler_jcb_description,
                brochureText = R.string.telehandler_jcb_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            ),
            Machine(
                id = 9,
                serialNumber = "SN009",
                name = "Bobcat E165",
                category = MachineCategory.SNELHEIDSGRAAFMACHINE,
                imageResourceId = R.drawable.graafmachine,
                description = R.string.excavator_bobcat_description,
                brochureText = R.string.excavator_bobcat_brochureText,
                optionList = listOf(
                    Option(
                        id = 1,
                        code = "1203",
                        description = "Blinderen, helft cabine ruiten (linker ruit achter de deur, achterruit en de helft van de rechter ruit)",
                        price = 518.00,
                        optionCategory = OptionCategory(
                            id = 1,
                            code = "1200",
                            name = "Belettering / Blinderen"
                        )
                    )
                )
            )
        )
    }
}