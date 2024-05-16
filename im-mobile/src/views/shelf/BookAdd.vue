<template>
  <van-form @submit="onSubmit">
    <van-cell-group inset>
      <van-field
          v-model="from.bookName"
          name="书名"
          label="书名"
          placeholder="书名"
          :rules="[{ required: true, message: '请填写书名' }]"
      />
      <van-field
          v-model="from.location"
          name="位置"
          label="位置"
          placeholder="位置"
          :rules="[{ required: true, message: '请填写位置' }]"
      />
      <van-field
          v-model="from.fieldValue"
          is-link
          readonly
          label="地区"
          placeholder="请选择所在地区"
          @click="show = true"
      />
      <van-popup v-model:show="show" round position="bottom">
        <van-cascader
            v-model="from.cascaderValue"
            title="请选择所在地区"
            :options="options"
            @close="show = false"
            @finish="onFinish"
        />
      </van-popup>

      <van-field
          v-model="from.type"
          name="分类"
          label="分类"
          placeholder="分类"
          :rules="[{ required: true, message: '请填写分类' }]"
      />
    </van-cell-group>
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>
</template>

<script setup lang="ts">
import {ref} from 'vue'
import { useCascaderAreaData } from '@vant/area-data';

const from = ref({
  fieldValue:'',
  cascaderValue:'',
  bookName:'',
  type:'',
  location:'',
})

const show = ref(false);
const fieldValue = ref('');
const cascaderValue = ref('');
const options = useCascaderAreaData();

const bookName = ref('');
const location = ref('');
const type = ref('');

const onSubmit = (values:any) => {
  console.log('submit', values);
};


const onFinish = ({ selectedOptions }) => {
  show.value = false;
  fieldValue.value = selectedOptions.map((option) => option.text).join('/');
};
</script>

<style scoped>

</style>