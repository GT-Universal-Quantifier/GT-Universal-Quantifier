import net.minecraftforge.fml.common.gameevent.PlayerEvent
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraft.util.EnumHand
import gregtech.common.items.MetaItems
import net.minecraftforge.fml.common.gameevent.PlayerEvent
import net.minecraft.util.SoundCategory
import net.minecraft.init.SoundEvents

event_manager.listen { PlayerEvent.ItemCraftedEvent event ->
    def player = event.player
    if (player == null) return
    if (player.world.isRemote) return

    def crafted = event.crafting
    if (crafted == null) return

    if (crafted.isItemEqual(item('gtuq:crude_knapped_stone'))) {
        def n = crafted.getCount()
        player.dropItem(item('gtuq:stone_shard') * n, false)

        float volume = 0.8f
        float pitch  = (0.9f + (player.world.rand.nextFloat() * 0.2f)) as float

        player.world.playSound(
            null,
            player.posX, player.posY, player.posZ,
            SoundEvents.BLOCK_STONE_HIT,
            SoundCategory.PLAYERS,
            volume,
            pitch
        )
    }
}

event_manager.listen { PlayerEvent.ItemCraftedEvent event ->
    def player = event.player
    if (player == null) return
    if (player.world.isRemote) return

    def crafted = event.crafting
    if (crafted == null) return

    if (crafted.isItemEqual(item('gtuq:crude_knapped_flint'))) {
        def n = crafted.getCount()
        player.dropItem(item('notreepunching:flint_shard') * n, false)

        float volume = 0.8f
        float pitch  = (0.9f + (player.world.rand.nextFloat() * 0.2f)) as float

        player.world.playSound(
            null,
            player.posX, player.posY, player.posZ,
            SoundEvents.BLOCK_STONE_BREAK,
            SoundCategory.PLAYERS,
            volume,
            pitch
        )
    }
}

event_manager.listen { PlayerEvent.ItemCraftedEvent event ->
    def player = event.player
    if (player == null) return
    if (player.world.isRemote) return

    def crafted = event.crafting
    if (crafted == null) return

    if (crafted.isItemEqual(item('gtuq:knapped_flint'))) {
        def n = crafted.getCount()
        player.dropItem(item('notreepunching:flint_shard') * n, false)

        float volume = 0.8f
        float pitch  = (0.9f + (player.world.rand.nextFloat() * 0.2f)) as float

        player.world.playSound(
            null,
            player.posX, player.posY, player.posZ,
            SoundEvents.BLOCK_STONE_BREAK,
            SoundCategory.PLAYERS,
            volume,
            pitch
        )
    }
}

event_manager.listen { PlayerEvent.ItemCraftedEvent event ->
    def player = event.player
    if (player == null) return
    if (player.world.isRemote) return

    def crafted = event.crafting
    if (crafted == null) return

    if (crafted.isItemEqual(item('gtuq:soaked_antler_billet'))) {
        def n = crafted.getCount()
        player.dropItem(item('gtuq:soaked_antler_piece') * n, false)

        float volume = 0.8f
        float pitch  = (0.9f + (player.world.rand.nextFloat() * 0.2f)) as float

        player.world.playSound(
            null,
            player.posX, player.posY, player.posZ,
            SoundEvents.ENTITY_SHEEP_SHEAR,
            SoundCategory.PLAYERS,
            volume,
            pitch
        )
    }
}

event_manager.listen { PlayerInteractEvent.RightClickItem event ->
    if (event.world.isRemote) return
    if (event.hand != EnumHand.MAIN_HAND) return

    def player = event.entityPlayer
    def main = player.heldItemMainhand
    def off  = player.heldItemOffhand

    if (main.isEmpty() || off.isEmpty()) return
    if (!MetaItems.PLANT_BALL.isItemEqual(main)) return
    if (!MetaItems.PLANT_BALL.isItemEqual(off))  return

    main.shrink(1)
    off.shrink(1)

    int count = 1 + event.world.rand.nextInt(3)

    def out = item("notreepunching:grass_fiber").copy()
    out.setCount(count)

    if (!player.inventory.addItemStackToInventory(out)) {
        player.dropItem(out, false)
    }

    event.canceled = true
}