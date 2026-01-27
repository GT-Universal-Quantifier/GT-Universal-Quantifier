import net.minecraftforge.event.entity.player.ItemTooltipEvent

def BIND_PLANT_FIBER = "§2Plant Fiber"
def BIND_SOAKED_HIDE = "§6Soaked Rawhide"

event_manager.listen { ItemTooltipEvent event ->
    def st = event.itemStack
    if (st == null || st.isEmpty()) return

    def id = st.item?.registryName?.toString()
    if (id != "gtuq:rock_fiber_crude_shovel" && id != "gtuq:rock_soaked_rawhide_crude_shovel") return

    def binding = (id == "gtuq:rock_fiber_crude_shovel") ? BIND_PLANT_FIBER : BIND_SOAKED_HIDE

    def lines = [
        ("§8Binding: " + binding).toString()
    ]

    int insertAt = -1
    for (int i = 0; i < event.toolTip.size(); i++) {
        def s = event.toolTip.get(i)
        if (s == null) continue
        def plain = s.toString().replaceAll("§.", "")
        if (plain.startsWith("When in ")) {
            insertAt = i
            break
        }
    }

    if (insertAt < 0) insertAt = event.toolTip.size()

    event.toolTip.addAll(insertAt, lines)
}
