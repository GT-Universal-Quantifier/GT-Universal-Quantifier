import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import net.minecraftforge.event.entity.living.LivingDropsEvent
import net.minecraft.block.BlockLeaves
import gregtech.common.items.MetaItems
import net.minecraft.entity.passive.EntityCow
import its_meow.betteranimalsplus.common.entity.EntityReindeer
import net.minecraft.init.Items
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.init.Enchantments
import net.minecraft.entity.item.EntityItem
import net.minecraft.util.math.MathHelper
import net.minecraft.item.ItemStack
import net.minecraft.item.Item
import groovy.transform.Field

event_manager.listen { HarvestDropsEvent event ->
    if (event.state.block instanceof BlockLeaves) {
        if (Math.random() < 0.03)
            event.getDrops().add(MetaItems.PLANT_BALL.getStackForm(1))
    }
}

@Field boolean printedMissing = false

def stackFromId(String id, int count) {
    Item it = Item.getByNameOrId(id)
    if (it == null || it == Items.AIR) return ItemStack.EMPTY
    return new ItemStack(it, count, 0)
}

event_manager.listen { LivingDropsEvent event ->
    def ent = event.entityLiving
    if (ent == null) return

    if (!(ent.class.name.endsWith("EntityReindeer"))) return

    def world = ent.world
    if (world == null) return

    int looting = 0
    def killer = event.source?.trueSource
    if (killer != null) {
        def held = killer.heldItemMainhand
        if (held != null) {
            looting = EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING, held)
        }
    }

    int rawhideCount = world.rand.nextInt(3) + world.rand.nextInt(looting + 1)
    int antlerCount  = (world.rand.nextInt(100) < (25 + looting * 5)) ? 1 : 0

    event.drops.removeIf { drop -> drop?.item != null && drop.item.item == Items.LEATHER }

    ItemStack rh  = (rawhideCount > 0) ? stackFromId("gtuq:rawhide", rawhideCount) : ItemStack.EMPTY
    ItemStack ant = (antlerCount  > 0) ? stackFromId("betteranimalsplus:antler",  antlerCount)  : ItemStack.EMPTY

    if (rh != null && !rh.isEmpty()) {
        event.drops.add(new EntityItem(world, ent.posX, ent.posY, ent.posZ, rh))
    }
    if (ant != null && !ant.isEmpty()) {
        event.drops.add(new EntityItem(world, ent.posX, ent.posY, ent.posZ, ant))
    }
}

event_manager.listen { LivingDropsEvent event ->
    def ent = event.entityLiving
    if (ent == null) return

    if (!(ent.class.name.endsWith("EntityCow"))) return

    def world = ent.world
    if (world == null) return

    int looting = 0
    def killer = event.source?.trueSource
    if (killer != null) {
        def held = killer.heldItemMainhand
        if (held != null) {
            looting = EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING, held)
        }
    }

    int rawhideCount = world.rand.nextInt(3) + world.rand.nextInt(looting + 1)

    event.drops.removeIf { drop -> drop?.item != null && drop.item.item == Items.LEATHER }

    ItemStack rh  = (rawhideCount > 0) ? stackFromId("gtuq:rawhide", rawhideCount) : ItemStack.EMPTY

    if (rh != null && !rh.isEmpty()) {
        event.drops.add(new EntityItem(world, ent.posX, ent.posY, ent.posZ, rh))
    }
}
