package org.imgaine.gaigegaigekaigecraft.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class CursedSpiritGrade37EntityDiesProcedure {
   public CursedSpiritGrade37EntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      double num_a = 0.0;
      double num_b = 0.0;
      if (!world.isClientSide() && world.getServer() != null) {
         for(ObjectListIterator var11 = world.getServer().getLootData().getLootTable(new ResourceLocation("gaigegaigekaigecraft:entities/stevenson_screen")).getRandomItems((new LootParams.Builder((ServerLevel)world)).create(LootContextParamSets.EMPTY)).iterator(); var11.hasNext(); ++num_a) {
            ItemStack itemstackiterator = (ItemStack)var11.next();
         }
      }

      num_b = Math.ceil(num_a * Math.random());
      num_a = 0.0;
      if (!world.isClientSide() && world.getServer() != null) {
         ObjectListIterator var17 = world.getServer().getLootData().getLootTable(new ResourceLocation("gaigegaigekaigecraft:entities/stevenson_screen")).getRandomItems((new LootParams.Builder((ServerLevel)world)).create(LootContextParamSets.EMPTY)).iterator();

         while(var17.hasNext()) {
            ItemStack itemstackiterator = (ItemStack)var17.next();
            ++num_a;
            if (num_a == num_b && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }
      }

   }
}
