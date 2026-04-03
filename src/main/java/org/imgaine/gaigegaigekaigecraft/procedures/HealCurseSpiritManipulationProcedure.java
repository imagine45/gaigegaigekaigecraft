package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class HealCurseSpiritManipulationProcedure {
   public HealCurseSpiritManipulationProcedure() {
   }

   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double heal_amount = 0.0;
         if (entity.isAlive()) {
            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 18.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18.0) {
               entity.getPersistentData().putDouble("cnt_cursed_spirit_manipulation", entity.getPersistentData().getDouble("cnt_cursed_spirit_manipulation") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_cursed_spirit_manipulation") > 100.0) {
                  entity.getPersistentData().putDouble("cnt_cursed_spirit_manipulation", 0.0);
                  if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                     label74: {
                        x_pos = 0.0;
                        z_pos = 0.0;
                        if (entity instanceof Player) {
                           Player _plr = (Player)entity;
                           if (_plr.getAbilities().instabuild) {
                              heal_amount = 9999.0;
                              break label74;
                           }
                        }

                        heal_amount = 5.0;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _origLevel = (ServerLevel)world;
                        LevelAccessor _worldorig = world;
                        LevelAccessor var28 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
                        if (var28 != null) {
                           Vec3 _center = new Vec3(0.0, 128.0, 0.0);

                           for(Entity entityiterator : var28.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
                              if (!(entityiterator instanceof Player) && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                                 float var10000;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10000 = _livEnt.getHealth();
                                 } else {
                                    var10000 = -1.0F;
                                 }

                                 float var10001;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10001 = _livEnt.getMaxHealth();
                                 } else {
                                    var10001 = -1.0F;
                                 }

                                 if (var10000 < var10001 && entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       var10001 = _livEnt.getHealth();
                                    } else {
                                       var10001 = -1.0F;
                                    }

                                    double var35 = (double)var10001 + heal_amount;
                                    double var10002;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       var10002 = (double)_livEnt.getMaxHealth();
                                    } else {
                                       var10002 = -1.0;
                                    }

                                    _entity.setHealth((float)Math.min(var35, var10002));
                                 }
                              }
                           }
                        }

                        world = _worldorig;
                     }
                  }
               }
            }

            if (entity.getPersistentData().getBoolean("UpdateSkills")) {
               entity.getPersistentData().putBoolean("UpdateSkills", false);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
