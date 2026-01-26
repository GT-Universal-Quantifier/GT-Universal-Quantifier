import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import net.minecraftforge.event.entity.living.LivingDropsEvent
import net.minecraft.block.BlockLeaves
import gregtech.common.items.MetaItems
import net.minecraft.entity.passive.EntityCow
import net.minecraft.init.Items
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.init.Enchantments
import net.minecraft.entity.item.EntityItem
import net.minecraft.util.math.MathHelper

event_manager.listen { HarvestDropsEvent event ->
    if (event.state.block instanceof BlockLeaves) {
        if (Math.random() < 0.03)
            event.getDrops().add(MetaItems.PLANT_BALL.getStackForm(1))
    }
}

event_manager.listen { LivingDropsEvent event ->
    if (!(event.entityLiving instanceof EntityCow)) return

    def world = event.entityLiving.world
    int looting = 0
    def killer = event.source?.trueSource
    if (killer != null) {
        def held = killer.heldItemMainhand
        if (held != null) {
            looting = EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING, held)
        }
    }

    int count = world.rand.nextInt(3) + world.rand.nextInt(looting + 1)

    // Remove leather
    event.drops.removeIf { drop ->
        drop.item != null && drop.item.item == Items.LEATHER
    }

    // Add rawhide
    if (count > 0) {
        event.drops.add(new EntityItem(
            world,
            event.entityLiving.posX,
            event.entityLiving.posY,
            event.entityLiving.posZ,
            item('gtuq:rawhide', count)
        ))
    }
}