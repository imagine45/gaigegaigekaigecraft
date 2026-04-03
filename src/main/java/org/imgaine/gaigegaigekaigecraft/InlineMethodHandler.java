package org.imgaine.gaigegaigekaigecraft;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.imgaine.gaigegaigekaigecraft.entity.*;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;

import java.util.Comparator;

public class InlineMethodHandler {

    public static boolean checkGamemodeCreative(Entity _ent) {
        if (_ent instanceof ServerPlayer _serverPlayer) {
            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
        } else {
            return false;
        }
    }

    public static boolean checkGamemodeSpectator(Entity _ent) {
        if (_ent instanceof ServerPlayer _serverPlayer) {
            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
        } else {
            return false;
        }
    }

    public static double getValue(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
    }

    public static String getValueBlank(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
    }

    public static boolean getValueFalse(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
    }

    public static Projectile getArrowBulletBlood(Level level, Entity shooter, float damage, int knockback) {
        AbstractArrow entityToSpawn = new BulletBloodProjectileEntity((EntityType) JujutsucraftModEntities.BULLET_BLOOD_PROJECTILE.get(), level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setSilent(true);
        return entityToSpawn;
    }

    public static Projectile getArrowBulletSkeleton(Level level, Entity shooter, float damage, int knockback) {
        AbstractArrow entityToSpawn = new BulletBloodProjectileEntity((EntityType) JujutsucraftModEntities.BULLET_SKELETON_PROJECTILE.get(), level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setSilent(true);
        return entityToSpawn;
    }

    public static Projectile getArrowBulletCannon(Level level, Entity shooter, float damage, int knockback, byte piercing) {
        AbstractArrow entityToSpawn = new BulletCannonProjectileEntity((EntityType) JujutsucraftModEntities.BULLET_CANNON_PROJECTILE.get(), level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setPierceLevel(piercing);
        entityToSpawn.setSilent(true);
        return entityToSpawn;
    }

    public static Projectile getArrowBulletPistol(Level level, Entity shooter, float damage, int knockback, byte piercing) {
        AbstractArrow entityToSpawn = new BulletPistolEntity((EntityType) JujutsucraftModEntities.BULLET_PISTOL.get(), level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setPierceLevel(piercing);
        entityToSpawn.setSilent(true);
        return entityToSpawn;
    }

    public static Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
        AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setPierceLevel(piercing);
        entityToSpawn.setCritArrow(true);
        return entityToSpawn;
    }

    public Projectile getArrowO(Level level, Entity shooter, float damage, int knockback, byte piercing) {
        AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setPierceLevel(piercing);
        entityToSpawn.setCritArrow(true);
        return entityToSpawn;
    }

    public static Projectile getArrowBulletHuman(Level level, Entity shooter, float damage, int knockback, byte piercing) {
        AbstractArrow entityToSpawn = new BulletHumanProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_HUMAN_PROJECTILE.get(), level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setSilent(true);
        entityToSpawn.setPierceLevel(piercing);
        entityToSpawn.setCritArrow(true);
        return entityToSpawn;
    }

    public static Projectile getArrowBulletCursePower(Level level, Entity shooter, float damage, int knockback, byte piercing) {
        AbstractArrow entityToSpawn = new BulletCursePowerProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_CURSE_POWER_PROJECTILE.get(), level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setSilent(true);
        entityToSpawn.setPierceLevel(piercing);
        entityToSpawn.setCritArrow(true);
        return entityToSpawn;
    }

    public static Projectile getArrowBulletNail(Level level, Entity shooter, float damage, int knockback) {
        AbstractArrow entityToSpawn = new BulletNailEntity((EntityType)JujutsucraftModEntities.BULLET_NAIL.get(), level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setSilent(true);
        entityToSpawn.setCritArrow(true);
        entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
        return entityToSpawn;
    }

    public static Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
        return Comparator.comparingDouble((_entcnd) -> _entcnd.distanceToSqr(_x, _y, _z));
    }

    public static double getY(CommandContext<CommandSourceStack> arguments) {
        try {
            return (double) BlockPosArgument.getLoadedBlockPos(arguments, "position").getY();
        } catch (CommandSyntaxException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public static double getX(CommandContext<CommandSourceStack> arguments) {
        try {
            return (double) BlockPosArgument.getLoadedBlockPos(arguments, "position").getX();
        } catch (CommandSyntaxException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public static double getZ(CommandContext<CommandSourceStack> arguments) {
        try {
            return (double) BlockPosArgument.getLoadedBlockPos(arguments, "position").getZ();
        } catch (CommandSyntaxException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public static double getSubmergedHeight(Entity _entity) {
        for(FluidType fluidType : ((IForgeRegistry<FluidType>)ForgeRegistries.FLUID_TYPES.get()).getValues()) {
            if (_entity.level().getFluidState(_entity.blockPosition()).getFluidType() == fluidType) {
                return _entity.getFluidTypeHeight(fluidType);
            }
        }

        return 0.0;
    }

    double convert(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception var3) {
            return 0.0;
        }
    }

    /*Comparator<Entity> compareDistOfO(double _x, double _y, double _z) {
        return Comparator.comparingDouble((_entcnd) -> _entcnd.distanceToSqr(_x, _y, _z));
    }*/

}
