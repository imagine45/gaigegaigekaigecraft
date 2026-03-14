package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class AuthenticMutualLoveActiveProcedure {
   public AuthenticMutualLoveActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double HP;
         double num1;
         double range;
         double var10000;
         label180: {
            String STR1 = "";
            ItemStack item_a = ItemStack.f_41583_;
            boolean failed = false;
            boolean logic_attack = false;
            double old_skill = 0.0;
            HP = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double tick = 0.0;
            double z_pos = 0.0;
            num1 = 0.0;
            double y_pos = 0.0;
            double old_skill_domain = 0.0;
            double num3 = 0.0;
            double num2 = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label180;
               }
            }

            var10000 = 0.0;
         }

         double var50 = var10000;
         if (!entity.getPersistentData().m_128471_("Failed")) {
            double var46 = entity.getPersistentData().m_128459_("skill");
            double var48 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
            String var42 = "";
            boolean var45 = false;
            if (entity instanceof Player) {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var78 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var78.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     if (itemstackiterator.m_41720_() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.m_41784_().m_128459_("skill") > 0.0) {
                        var45 = true;
                        entity.getPersistentData().m_128347_("skill", itemstackiterator.m_41784_().m_128459_("skill"));
                        entity.getPersistentData().m_128347_("effect", itemstackiterator.m_41784_().m_128459_("effect"));
                        entity.getPersistentData().m_128347_("COOLDOWN_TICKS", itemstackiterator.m_41784_().m_128459_("COOLDOWN_TICKS"));
                        num1 = itemstackiterator.m_41784_().m_128459_("COOLDOWN_TICKS");
                        var42 = itemstackiterator.m_41784_().m_128461_("SHIKIGAMI_NAME");
                        HP = itemstackiterator.m_41784_().m_128459_("SHIKIGAMI_HP");
                        break;
                     }
                  }
               }
            } else {
               num1 = 0.0;

               for(int index0 = 0; index0 < 4; ++index0) {
                  ItemStack var73;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var73 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)num1));
                  } else {
                     var73 = ItemStack.f_41583_;
                  }

                  ItemStack var43 = var73.m_41777_();
                  if (var43.m_41784_().m_128459_("skill") > 0.0) {
                     var45 = true;
                     entity.getPersistentData().m_128347_("skill", var43.m_41784_().m_128459_("skill"));
                     entity.getPersistentData().m_128347_("effect", var43.m_41784_().m_128459_("effect"));
                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var43.m_41784_().m_128459_("COOLDOWN_TICKS"));
                     num1 = var43.m_41784_().m_128459_("COOLDOWN_TICKS");
                     var42 = var43.m_41784_().m_128461_("SHIKIGAMI_NAME");
                     HP = var43.m_41784_().m_128459_("SHIKIGAMI_HP");
                     break;
                  }

                  ++num1;
                  if (num1 > 3.0) {
                     break;
                  }
               }

               LivingEntity var74;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var74 = _mobEnt.m_5448_();
               } else {
                  var74 = null;
               }

               if (var74 instanceof LivingEntity) {
                  label197: {
                     if (var45) {
                        label189: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var74 = _mobEnt.m_5448_();
                           } else {
                              var74 = null;
                           }

                           LivingEntity var41 = var74;
                           if (var41 instanceof LivingEntity) {
                              LivingEntity _livEnt39 = var41;
                              if (_livEnt39.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label189;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var74 = _mobEnt.m_5448_();
                           } else {
                              var74 = null;
                           }

                           if (!((Entity)var74).getPersistentData().m_128471_("CursedSpirit")) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var74 = _mobEnt.m_5448_();
                              } else {
                                 var74 = null;
                              }

                              if (!((Entity)var74).getPersistentData().m_128471_("CurseUser")) {
                                 break label197;
                              }
                           }
                        }
                     }

                     var45 = true;
                     entity.getPersistentData().m_128347_("skill", 2815.0);
                     entity.getPersistentData().m_128347_("effect", 0.0);
                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", 350.0);
                     num1 = 350.0;
                     var42 = "jujutsucraft:entity_jacobs_ladder_circle";
                     HP = 200.0;
                  }
               }
            }

            if (var45) {
               if (var42.isEmpty()) {
                  if (entity.getPersistentData().m_128459_("skill") % 100.0 <= 20.0 && entity.getPersistentData().m_128459_("skill") >= 100.0 && (!(entity.getPersistentData().m_128459_("skill") >= 500.0) || !(entity.getPersistentData().m_128459_("skill") < 600.0))) {
                     double var54 = entity.getPersistentData().m_128459_("skill_domain");
                     entity.getPersistentData().m_128347_("skill_domain", Math.floor(entity.getPersistentData().m_128459_("skill") / 100.0));
                     DomainActiveProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().m_128347_("skill_domain", var54);
                  }
               } else if (var50 % (double)Math.round(Math.max(Math.ceil(num1 / 75.0), 1.0) * 40.0) == 0.0 || entity.getPersistentData().m_128471_("StartDomainAttack")) {
                  double var56 = Math.ceil(Math.max(250.0 - num1, 75.0) / 75.0);
                  boolean var44 = true;
                  Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && LogicAttackDomainProcedure.execute(world, entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        var44 = false;
                     }
                  }

                  if (var44) {
                     entity.getPersistentData().m_128379_("StartDomainAttack", true);
                  } else {
                     entity.getPersistentData().m_128379_("StartDomainAttack", false);
                     double var55 = 0.0;

                     for(int index1 = 0; index1 < (int)Math.round(var56); ++index1) {
                        ++var55;
                        if (Math.random() < 0.5 || var55 <= 1.0) {
                           num1 = Math.toRadians(Math.random() * 360.0);
                           double var49 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * (range / 2.0 - 4.0) + Math.random() * 0.5;
                           double var53 = entity.getPersistentData().m_128459_("y_pos_doma") + Math.random() * 0.5;
                           double var51 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * (range / 2.0 - 4.0) + Math.random() * 0.5;
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var49, var53, var51), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "summon " + var42 + " ~ ~ ~ {Health:" + Math.round(HP) + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + Math.toDegrees(num1) + "F,0F]}");
                           }

                           Vec3 _center = new Vec3(var49, var53, var51);

                           for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                              if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.getPersistentData().m_128459_("NameRanged_ranged") == 0.0) {
                                 SetRangedAmmoProcedure.execute(entity, entityiterator);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            entity.getPersistentData().m_128347_("skill", var46);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var48);
         }

      }
   }
}
