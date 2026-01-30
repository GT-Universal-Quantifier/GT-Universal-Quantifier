import net.minecraft.item.ItemSpade
import net.minecraft.item.Item
import net.minecraft.item.Item.ToolMaterial
import net.minecraftforge.common.util.EnumHelper
import com.alcatrazescapee.notreepunching.common.items.ItemKnife

content.createItem('stone_shard')
    .register()
content.createItem('rawhide')
    .register()
content.createItem('soaked_rawhide')
    .register()
content.createItem('dried_rawhide')
    .register()
content.createItem('crude_knapped_stone')
    .register()
content.createItem('soaked_antler')
    .register()
content.createItem('crude_knapped_flint')
    .register()
content.createItem('knapped_flint')
    .register()
content.createItem('antler_piece')
    .register()
content.createItem('soaked_antler_piece')
    .register()
content.createItem('flint_knife_head')
    .register()


def CRUDE_FIBER_STONE_SPADE = EnumHelper.addToolMaterial(
    "CRUDE_FIBER_ROCK",
    0,      // harvest level
    32,     // durability
    1.5f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('rock_fiber_crude_shovel',
    new ItemSpade(CRUDE_FIBER_STONE_SPADE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)

def CRUDE_SOAKED_RAWHIDE_STONE_SPADE = EnumHelper.addToolMaterial(
    "CRUDE_SOAKED_RAWHIDE_ROCK",
    0,      // harvest level
    24,     // durability
    1.4f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('rock_soaked_rawhide_crude_shovel',
    new ItemSpade(CRUDE_SOAKED_RAWHIDE_STONE_SPADE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)

def CRUDE_DRIED_RAWHIDE_STONE_SPADE = EnumHelper.addToolMaterial(
    "CRUDE_DRIED_RAWHIDE_ROCK",
    0,      // harvest level
    64,     // durability
    1.6f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('rock_dried_rawhide_crude_shovel',
    new ItemSpade(CRUDE_DRIED_RAWHIDE_STONE_SPADE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)

def CRUDE_FIBER_FLINT_KNIFE = EnumHelper.addToolMaterial(
    "CRUDE_FIBER_FLINT",
    0,      // harvest level
    2,     // durability
    1.5f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('crude_flint_fiber_knife',
    new ItemKnife(CRUDE_FIBER_FLINT_KNIFE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)

def CRUDE_SOAKED_RAWHIDE_FLINT_KNIFE = EnumHelper.addToolMaterial(
    "CRUDE_SOAKED_RAWHIDE_FLINT",
    0,      // harvest level
    1,     // durability
    1.4f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('crude_flint_soaked_rawhide_knife',
    new ItemKnife(CRUDE_SOAKED_RAWHIDE_FLINT_KNIFE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)

def CRUDE_DRIED_RAWHIDE_FLINT_KNIFE = EnumHelper.addToolMaterial(
    "CRUDE_DRIED_RAWHIDE_FLINT",
    0,      // harvest level
    4,     // durability
    1.6f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('crude_flint_dried_rawhide_knife',
    new ItemKnife(CRUDE_DRIED_RAWHIDE_FLINT_KNIFE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)

content.registerItem('soaked_antler_billet',
    new Item() {

        {
            setMaxStackSize(1)
            setMaxDamage(3)
            setNoRepair()
        }

        @Override
        boolean hasContainerItem(net.minecraft.item.ItemStack stack) {
            return true
        }

        @Override
        net.minecraft.item.ItemStack getContainerItem(net.minecraft.item.ItemStack stack) {
            def copy = stack.copy()
            copy.damageItem(1, null)

            if (copy.itemDamage >= copy.maxDamage) {
                return net.minecraft.item.ItemStack.EMPTY
            }

            return copy
        }
    }
)

content.registerItem('antler_billet',
    new Item() {

        {
            setMaxStackSize(1)
            setMaxDamage(12)
            setNoRepair()
        }

        @Override
        boolean hasContainerItem(net.minecraft.item.ItemStack stack) {
            return true
        }

        @Override
        net.minecraft.item.ItemStack getContainerItem(net.minecraft.item.ItemStack stack) {
            def copy = stack.copy()
            copy.damageItem(1, null)

            if (copy.itemDamage >= copy.maxDamage) {
                return net.minecraft.item.ItemStack.EMPTY
            }

            return copy
        }
    }
)

content.registerItem('crude_soaked_antler_billet',
    new Item() {

        {
            setMaxStackSize(1)
            setMaxDamage(1)
            setNoRepair()
        }

        @Override
        boolean hasContainerItem(net.minecraft.item.ItemStack stack) {
            return true
        }

        @Override
        net.minecraft.item.ItemStack getContainerItem(net.minecraft.item.ItemStack stack) {
            def copy = stack.copy()
            copy.damageItem(1, null)

            if (copy.itemDamage >= copy.maxDamage) {
                return net.minecraft.item.ItemStack.EMPTY
            }

            return copy
        }
    }
)

content.registerItem('crude_antler_billet',
    new Item() {

        {
            setMaxStackSize(1)
            setMaxDamage(3)
            setNoRepair()
        }

        @Override
        boolean hasContainerItem(net.minecraft.item.ItemStack stack) {
            return true
        }

        @Override
        net.minecraft.item.ItemStack getContainerItem(net.minecraft.item.ItemStack stack) {
            def copy = stack.copy()
            copy.damageItem(1, null)

            if (copy.itemDamage >= copy.maxDamage) {
                return net.minecraft.item.ItemStack.EMPTY
            }

            return copy
        }
    }
)