ore_dict.add('knife', item('gtuq:crude_flint_soaked_rawhide_knife'))
ore_dict.add('knife', item('gtuq:crude_flint_dried_rawhide_knife'))
ore_dict.add('knife', item('gtuq:crude_flint_fiber_knife'))
ore_dict.add('antlerBillet', item('gtuq:antler_billet'))
ore_dict.add('antlerBillet', item('gtuq:soaked_antler_billet'))
ore_dict.add('crudeAntlerBillet', item('gtuq:crude_antler_billet'))
ore_dict.add('crudeAntlerBillet', item('gtuq:crude_soaked_antler_billet'))

crafting.addShapeless(item('gtuq:crude_knapped_stone'), [item('notreepunching:rock/stone'),item('notreepunching:rock/stone')])
crafting.addShapeless(item('minecraft:dye', 15), [item('gtuq:antler_piece')])
crafting.addShapeless(item('gtuq:crude_knapped_flint'), [item('minecraft:flint'),item('minecraft:flint')])

def dmgTool(String idWithDamage, int add) {
    def wid = idWithDamage.contains(":*") ? idWithDamage : (idWithDamage + ":*")

    return item(wid).transform { st ->
        if (st.isItemStackDamageable()) {
            int newDmg = st.itemDamage + add
            if (newDmg >= st.maxDamage) return ItemStack.EMPTY
            def out = st.copy()
            out.itemDamage = newDmg
            return out
        }

        return st
    }
}

crafting.addShapeless(
    item("gtuq:soaked_antler_billet"),
    [
        dmgTool("notreepunching:knife/flint", 2),
        item("gtuq:soaked_antler")
    ]
)

crafting.addShapeless(
    item('gtuq:knapped_flint'),
    [
        item('minecraft:flint'),
        dmgTool('gtuq:antler_billet', 2)
    ]
)

crafting.addShapeless(
    item('gtuq:knapped_flint'),
    [
        item('gtuq:crude_knapped_flint'),
        dmgTool('gtuq:soaked_antler_billet', 1)
    ]
)

crafting.addShapeless(
    item('gtuq:knapped_flint'),
    [
        item('minecraft:flint'),
        dmgTool('gtuq:crude_antler_billet', 2)
    ]
)

crafting.addShapeless(
    item('gtuq:knapped_flint'),
    [
        item('gtuq:crude_knapped_flint'),
        dmgTool('gtuq:crude_soaked_antler_billet', 1)
    ]
)

crafting.addShapeless(
    item('gtuq:knapped_flint'),
    [
        item('gtuq:crude_knapped_flint'),
        dmgTool('gtuq:antler_billet', 1)
    ]
)

crafting.addShapeless(
    item('gtuq:knapped_flint'),
    [
        item('minecraft:flint'),
        dmgTool('gtuq:soaked_antler_billet', 2)
    ]
)

crafting.addShapeless(
    item('gtuq:knapped_flint'),
    [
        item('gtuq:crude_knapped_flint'),
        dmgTool('gtuq:crude_antler_billet', 1)
    ]
)

crafting.addShapeless(
    item('gtuq:knapped_flint'),
    [
        item('minecraft:flint'),
        dmgTool('gtuq:crude_soaked_antler_billet', 2)
    ]
)

crafting.addShapeless(
    item('gtuq:crude_soaked_antler_billet'),
    [
        item('gtuq:soaked_antler'),
        dmgTool('gtuq:crude_flint_soaked_rawhide_knife', 1)
    ]
)

crafting.addShapeless(
    item('gtuq:crude_soaked_antler_billet'),
    [
        item('gtuq:soaked_antler'),
        dmgTool('gtuq:crude_flint_dried_rawhide_knife', 1)
    ]
)

crafting.addShapeless(
    item('gtuq:crude_soaked_antler_billet'),
    [
        item('gtuq:soaked_antler'),
        dmgTool('gtuq:crude_flint_fiber_knife', 1)
    ]
)

crafting.addShapeless(
    item('gtuq:flint_knife_head'),
    [
        item('notreepunching:flint_shard'),
        item('notreepunching:flint_shard'),
        item('gtuq:knapped_flint'),
        dmgTool('gtuq:antler_billet', 3)
    ]
)

crafting.addShapeless(
    item('gtuq:flint_knife_head'),
    [
        item('notreepunching:flint_shard'),
        item('notreepunching:flint_shard'),
        item('gtuq:knapped_flint'),
        dmgTool('gtuq:crude_antler_billet', 3)
    ]
)



mods.tconstruct.drying.recipeBuilder()
    .input(item('gtuq:rock_soaked_rawhide_crude_shovel'))
    .output(item('gtuq:rock_dried_rawhide_crude_shovel'))
    .time(1200)
    .register()
mods.tconstruct.drying.recipeBuilder()
    .input(item('gtuq:crude_flint_soaked_rawhide_knife'))
    .output(item('gtuq:crude_flint_dried_rawhide_knife'))
    .time(1200)
    .register()
mods.tconstruct.drying.recipeBuilder()
    .input(item('gtuq:soaked_rawhide'))
    .output(item('gtuq:dried_rawhide'))
    .time(1500)
    .register()
mods.tconstruct.drying.recipeBuilder()
    .input(item("gtuq:soaked_antler_billet"))
    .output(item("gtuq:antler_billet"))
    .time(1200)
    .register()
mods.tconstruct.drying.recipeBuilder()
    .input(item("gtuq:soaked_antler"))
    .output(item("betteranimalsplus:antler"))
    .time(1500)
    .register()
mods.tconstruct.drying.recipeBuilder()
    .input(item("gtuq:crude_soaked_antler_billet"))
    .output(item("gtuq:crude_antler_billet"))
    .time(1200)
    .register()
mods.tconstruct.drying.recipeBuilder()
    .input(item("gtuq:soaked_antler_piece"))
    .output(item("gtuq:antler_piece"))
    .time(600)
    .register()