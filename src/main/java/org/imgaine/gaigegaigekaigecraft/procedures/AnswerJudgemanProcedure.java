package org.imgaine.gaigegaigekaigecraft.procedures;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import org.imgaine.gaigegaigekaigecraft.entity.HigurumaHiromiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AnswerJudgemanProcedure {
   public AnswerJudgemanProcedure() {
   }

   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         double x_dis = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double z_dis = 0.0;
         double y_dis = 0.0;
         boolean answered = false;
         Entity to_entity = null;
         String str_answer = "";
         to_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("JUDGE_ENTITY"));
         if (to_entity instanceof LivingEntity) {
            entity.getPersistentData().putString("JUDGE_ENTITY", "");
            entity.getPersistentData().remove("JUDGE_ENTITY");
            if (!(to_entity instanceof LivingEntity)) {
               return;
            }

            LivingEntity _livEnt5 = (LivingEntity)to_entity;
            if (!_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
               return;
            }

            if (to_entity.getPersistentData().getBoolean("Failed")) {
               return;
            }

            if (to_entity.getPersistentData().getDouble("skill") == 2719.0) {
               return;
            }

            answered = true;
            if (StringArgumentType.getString(arguments, "answer").equals("plea_silent")) {
               str_answer = Component.translatable("jujutsu.message.higuruma_answer1").getString();
            } else if (StringArgumentType.getString(arguments, "answer").equals("plea_confess")) {
               str_answer = Component.translatable("jujutsu.message.higuruma_answer2").getString();
               ResetCounterProcedure.execute(to_entity);
               if (to_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)to_entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                  }
               }

               to_entity.getPersistentData().putDouble("skill", 2719.0);
               to_entity.getPersistentData().putDouble("cnt3", 20.0);
               if (to_entity.getPersistentData().getDouble("x_power") <= 100.0) {
                  to_entity.getPersistentData().putDouble("x_power", 100.0);
               } else {
                  to_entity.getPersistentData().putDouble("x_power", Math.max(to_entity.getPersistentData().getDouble("x_power") - 15.0, 15.0));
               }
            } else if (StringArgumentType.getString(arguments, "answer").equals("plea_deny")) {
               str_answer = Component.translatable("jujutsu.message.higuruma_answer3").getString();
               if (to_entity.getPersistentData().getDouble("x_power") <= 100.0) {
                  if (Math.random() < 0.2) {
                     to_entity.getPersistentData().putDouble("x_power", 0.0);
                  } else {
                     to_entity.getPersistentData().putDouble("x_power", 100.0);
                  }
               } else if (Math.random() < 0.1) {
                  to_entity.getPersistentData().putDouble("x_power", 0.0);
               } else {
                  to_entity.getPersistentData().putDouble("x_power", to_entity.getPersistentData().getDouble("x_power") + 30.0);
               }
            } else {
               answered = false;
            }

            if (answered) {
               if (to_entity instanceof HigurumaHiromiEntity) {
                  to_entity.getPersistentData().putDouble("cnt_x3", 140.0);
               }

               range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
               Vec3 _center = new Vec3(to_entity.getPersistentData().getDouble("x_pos_doma"), to_entity.getPersistentData().getDouble("y_pos_doma"), to_entity.getPersistentData().getDouble("z_pos_doma"));

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                  if (entityiterator instanceof Player) {
                     x_dis = to_entity.getPersistentData().getDouble("x_pos_doma") - entityiterator.getX();
                     y_dis = to_entity.getPersistentData().getDouble("y_pos_doma") - (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                     z_dis = to_entity.getPersistentData().getDouble("z_pos_doma") - entityiterator.getZ();
                     distance = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (distance < range * 0.5 * range * 0.5 && entityiterator instanceof Player) {
                        Player _player = (Player)entityiterator;
                        if (!_player.level().isClientSide()) {
                           String var10001 = entity.getDisplayName().getString();
                           _player.displayClientMessage(Component.literal(var10001 + " -> §l\"" + str_answer + "\""), false);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
