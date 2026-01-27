import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem
import net.minecraftforge.event.entity.ProjectileImpactEvent
import net.minecraftforge.event.entity.ProjectileImpactEvent.Throwable

import net.minecraft.entity.projectile.EntitySnowball
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.SoundCategory
import net.minecraft.init.SoundEvents
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.DamageSource

final String SHARD_ID = "gtuq:stone_shard"
final String TAG_KEY  = "gtuq_shard_projectile"
final float SHARD_DAMAGE = 2.0f // 1 heart = 2.0f

event_manager.listen { RightClickItem event ->
    def player = event.entityPlayer
    if (player == null) return

    def world = player.world
    if (world == null || world.isRemote) return

    def stack = event.itemStack
    if (stack == null || stack.isEmpty()) return

    def id = stack.item?.registryName?.toString()
    if (id != SHARD_ID) return

    if (!player.capabilities.isCreativeMode) {
        stack.shrink(1)
    }

    def proj = new EntitySnowball(world, player)

    proj.entityData.setBoolean(TAG_KEY, true)

    proj.shoot(player, player.rotationPitch, player.rotationYaw, 0.0f, 1.5f, 1.0f)

    world.spawnEntity(proj)

    world.playSound(
        null,
        player.posX, player.posY, player.posZ,
        SoundEvents.ENTITY_SNOWBALL_THROW,
        SoundCategory.PLAYERS,
        0.5f,
        0.8f + (world.rand.nextFloat() * 0.4f)
    )

    event.cancellationResult = EnumActionResult.SUCCESS
    event.canceled = true
}

event_manager.listen { Throwable event ->
    def throwable = event.throwable
    if (!(throwable instanceof EntitySnowball)) return

    if (!throwable.entityData.getBoolean(TAG_KEY)) return

    def world = throwable.world
    if (world == null || world.isRemote) return

    RayTraceResult hit = event.rayTraceResult
    if (hit == null) return

    if (hit.typeOfHit == RayTraceResult.Type.ENTITY && hit.entityHit != null) {
        def target = hit.entityHit
        
        def thrower = throwable.thrower
        def src = DamageSource.causeThrownDamage(throwable, thrower)

        target.attackEntityFrom(src, SHARD_DAMAGE)
    }

}
