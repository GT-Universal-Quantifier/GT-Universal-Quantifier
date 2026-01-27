import net.minecraftforge.event.entity.player.ItemTooltipEvent

def BIND_PLANT_FIBER   = "§2Plant Fiber §r[§eModerate§r]"
def BIND_SOAKED_HIDE   = "§3Soaked Rawhide §r[§4Weak§r]"
def BIND_DRIED_HIDE    = "§6Dried Rawhide §r[§2Strong§r]"
def DEPRECATED         = "§4§l[DEPRECATED]"

event_manager.listen { ItemTooltipEvent event ->
    def st = event.itemStack
    if (st == null || st.isEmpty()) return

    def id = st.item?.registryName?.toString()
    if (id == null) return

    /* ---------------- DEPRECATED ANTLER ---------------- */
    if (id == "gtuq:antler") {
        int nameLine = 0
        int insertAt = (event.toolTip != null && event.toolTip.size() > 0) ? 1 : 0
        event.toolTip.add(insertAt, DEPRECATED.toString())
        return
    }

    /* ---------------- CRUDE SHOVELS ---------------- */
    if (
        id != "gtuq:rock_fiber_crude_shovel" &&
        id != "gtuq:rock_soaked_rawhide_crude_shovel" &&
        id != "gtuq:rock_dried_rawhide_crude_shovel"
    ) return

    def binding
    if (id == "gtuq:rock_fiber_crude_shovel") {
        binding = BIND_PLANT_FIBER
    } else if (id == "gtuq:rock_soaked_rawhide_crude_shovel") {
        binding = BIND_SOAKED_HIDE
    } else if (id == "gtuq:rock_dried_rawhide_crude_shovel") {
        binding = BIND_DRIED_HIDE
    }

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