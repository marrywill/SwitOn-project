<template>
	<form
		class="studyform"
		@submit.prevent="submitForm"
		enctype="multipart/form-data"
	>
		<section class="studyform-header">
			<h2>스터디 생성</h2>
			<div class="study-btnbox">
				<button @click.prevent="$router.go(-1)" class="studyform-btn-cancle">
					취소
				</button>
				<button :disabled="!isVaildId" class="hide-btn">작성</button>
				<button
					:disabled="!isVaildId"
					class="studyform-btn-submit"
					type="submit"
				>
					작성
				</button>
			</div>
		</section>
		<section class="studyform-main">
			<div class="studyform-title">
				<label class="head-label" for="name"
					>이름
					<span class="study-title-vaildate" v-if="!isVaildId">
						(※ 이름은 10자 이하로 작성해주세요)
					</span>
				</label>
				<input
					class="studyform-input"
					v-model="studyData.name"
					id="name"
					type="text"
				/>
			</div>
			<div class="studyform-content">
				<label class="head-label" for="description">소개</label>
				<textarea
					v-model="studyData.description"
					id="description"
					class="studyform-input"
					type="text"
					row="8"
				/>
			</div>
			<div class="studyform-userlimit">
				<label class="head-label" for="users_limit">제한 인원</label>
				<input
					class="studyform-input"
					v-model="studyData.users_limit"
					id="users_limit"
					type="number"
					min="2"
					max="20"
					required
				/>
			</div>
			<div class="studyform-time">
				<label for="start_time" class="head-label">시간</label>
				<input
					v-model="studyData.start_time"
					id="start_time"
					type="time"
					required
				/>
				<label for="end_time">부터</label>
				<input
					v-model="studyData.end_time"
					id="end_time"
					type="time"
					required
				/>
				<label>까지</label>
			</div>
			<div class="studyform-category">
				<div class="studyform-uppercategory">
					<label for="uppercategory_id" class="head-label">카테고리</label>
					<select v-model="uppercategory_id" id="uppercategory_id" required>
						<option value="1">웹</option>
						<option value="2">모바일</option>
						<option value="3">프로그래밍 언어</option>
						<option value="4">AI</option>
						<option value="5">CS</option>
						<option value="6">언어</option>
					</select>
				</div>
				<div class="studyform-lowercategory">
					<select
						v-model="studyData.lowercategory_id"
						id="lowercategory_id"
						required
					>
						<option v-if="uppercategory_id === '1'" value="1">Django</option>
						<option v-if="uppercategory_id === '1'" value="2">Spring</option>
						<option v-if="uppercategory_id === '1'" value="3">Node.Js</option>
						<option v-if="uppercategory_id === '1'" value="4">Vue</option>
						<option v-if="uppercategory_id === '1'" value="5">React</option>
						<option v-if="uppercategory_id === '1'" value="6">HTML/CSS</option>
						<option v-if="uppercategory_id === '1'" value="7"
							>Javascript</option
						>
						<option v-if="uppercategory_id === '1'" value="8">Database</option>
						<option v-if="uppercategory_id === '2'" value="10">Android</option>
						<option v-if="uppercategory_id === '2'" value="11">IOS</option>
						<option v-if="uppercategory_id === '2'" value="12">Flutter</option>
						<option v-if="uppercategory_id === '2'" value="13"
							>React Native</option
						>
						<option v-if="uppercategory_id === '3'" value="15">Python</option>
						<option v-if="uppercategory_id === '3'" value="16">C</option>
						<option v-if="uppercategory_id === '3'" value="17">C#</option>
						<option v-if="uppercategory_id === '3'" value="18">C++</option>
						<option v-if="uppercategory_id === '3'" value="19">Java</option>
						<option v-if="uppercategory_id === '3'" value="20">Kotlin</option>
						<option v-if="uppercategory_id === '3'" value="21">Swift</option>
						<option v-if="uppercategory_id === '3'" value="22">R</option>
						<option v-if="uppercategory_id === '4'" value="24">머신러닝</option>
						<option v-if="uppercategory_id === '4'" value="25">딥러닝</option>
						<option v-if="uppercategory_id === '4'" value="26">OpenCV</option>
						<option v-if="uppercategory_id === '4'" value="27"
							>텐서플로우</option
						>
						<option v-if="uppercategory_id === '4'" value="28">케라스</option>

						<option v-if="uppercategory_id === '5'" value="30">자료구조</option>
						<option v-if="uppercategory_id === '5'" value="31">알고리즘</option>
						<option v-if="uppercategory_id === '5'" value="32">네트워크</option>
						<option v-if="uppercategory_id === '5'" value="33"
							>컴퓨터구조</option
						>
						<option v-if="uppercategory_id === '5'" value="34"
							>소프트웨어공학</option
						>
						<option v-if="uppercategory_id === '5'" value="35">운영체제</option>
						<option v-if="uppercategory_id === '6'" value="37">영어</option>
						<option v-if="uppercategory_id === '6'" value="38">한국어</option>
						<option v-if="uppercategory_id === '6'" value="39">중국어</option>
						<option v-if="uppercategory_id === '6'" value="40">일본어</option>
					</select>
				</div>
			</div>
			<div class="studyform-term">
				<label for="start_term" class="head-label">일정</label>
				<input
					v-model="studyData.start_term"
					id="start_term"
					type="date"
					required
				/>
				<label for="end_term">부터</label>
				<input
					v-model="studyData.end_term"
					id="end_term"
					type="date"
					required
				/>
				<label>까지</label>
			</div>
			<div class="studyform-week">
				<label class="head-label">요일</label>
				<input type="checkbox" id="Mon" value="64" v-model="weekData" />
				<label for="Mon">월</label>
				<input type="checkbox" id="Tue" value="32" v-model="weekData" />
				<label for="Tue">화</label>
				<input type="checkbox" id="Wed" value="16" v-model="weekData" />
				<label for="Wed">수</label>
				<input type="checkbox" id="Thu" value="8" v-model="weekData" />
				<label for="Thu">목</label>
				<input type="checkbox" id="Fri" value="4" v-model="weekData" />
				<label for="Fri">금</label>
				<input type="checkbox" id="Sat" value="2" v-model="weekData" />
				<label for="Sat">토</label>
				<input type="checkbox" id="Sun" value="1" v-model="weekData" />
				<label for="Sun">일</label>
			</div>
			<div class="upload-btn_wrap">
				<input
					v-model="fileRoute"
					type="text"
					class="upload_text"
					readonly="readonly"
					placeholder="첨부된 파일이 없습니다."
				/>
				<button type="button" title="첨부">
					<span>로고</span>
				</button>
				<input
					ref="inputFile"
					type="file"
					class="input_file"
					title="첨부"
					@change="onChangeFile"
				/>
			</div>
		</section>
	</form>
</template>

<script>
import bus from '@/utils/bus.js';
import { createStudy } from '@/api/studies';
export default {
	data() {
		return {
			fileRoute: null,
			weekData: [],
			uppercategory_id: null,
			studyData: {
				name: '',
				description: null,
				week: null,
				isRecruit: 1,
				img: null,
				isPrivate: 0,
				lowercategory_id: null,
				start_term: null,
				end_term: null,
				start_time: null,
				end_time: null,
				users_limit: null,
			},
		};
	},

	methods: {
		weekCalculator() {
			this.studyData.week = this.weekData.reduce(
				(acc, cur) => acc + parseInt(cur),
				0,
			);
		},
		async submitForm() {
			try {
				this.weekCalculator();
				this.studyData.users_limit = parseInt(this.studyData.users_limit);
				this.studyData.lowercategory_id = parseInt(
					this.studyData.lowercategory_id,
				);
				const { data } = await createStudy(this.studyData);
				const studyId = data;
				this.$router.push(`/study/${studyId}`);
			} catch (error) {
				if (error.response.status === 500) {
					if (error.response.data.msg === undefined) {
						bus.$emit(
							'show:toast',
							'파일의 용량 제한을 초과했습니다. 최대 5mb까지 가능합니다.',
						);
					} else {
						bus.$emit('show:toast', `${error.response.data.msg}`);
					}
				} else {
					bus.$emit('show:toast', `${error.response.data.msg}`);
				}
			}
		},
		onChangeFile(e) {
			this.fileRoute = e.target.value;
			this.studyData.img = this.$refs.inputFile.files[0];
		},
	},

	computed: {
		isVaildId() {
			let a = this.studyData.name.length;
			return a < 11 ? true : false;
		},
	},
};
</script>

<style lang="scss">
.studyform {
	width: 70%;
	margin: 0 auto 3rem;
	height: 100%;
	@media screen and (max-width: 768px) {
		width: 95%;
	}
}
#fileInput {
	display: none;
}

.study-title-vaildate {
	color: red;
	font-size: $font-light;
	padding-left: 0.75rem;
}

.studyform-header {
	display: flex;
	position: relative;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 1rem;
	.studyform-btn-cancle {
		@include form-btn('white');
		margin-right: 5px;
	}
	.studyform-btn-submit {
		@include form-btn('purple');
		position: relative;
		right: 0;
		:disabled {
			display: none;
		}
	}
	.hide-btn {
		border: none;
		border-radius: 3px;
		height: 40px;
		padding: 0 1.125rem;
		font-size: 1rem;
		font-weight: 700;
		text-decoration: none solid #000;
		background: #000;
		color: #fff;
		position: absolute;
		right: 0;
		:disabled {
			background-color: gray;
		}
	}
}
.studyform-main {
	box-shadow: 0 2px 6px 0 rgba(68, 67, 68, 0.4);
	padding: 1rem;
	border-radius: 4px;
	div {
		margin-bottom: 0.75rem;
	}
	.studyform-input {
		width: 100%;
		padding: 10px;
		border: none;
		border-radius: 0;
		border-bottom: 1px solid black;
		&:focus {
			outline: none;
			border-bottom: 1px solid black;
		}
	}
	textarea {
		height: 10rem;
	}
}
.studyform-week {
	input[type='checkbox'] {
		margin-right: 2px;
	}
	label {
		margin-right: 5px;
	}
}
.studyform-private {
	input[type='radio'] {
		margin-right: 2px;
	}
	label {
		margin-right: 5px;
	}
}
.head-label {
	display: block;
	font-weight: 600;
}
input.upload_text {
	flex: 1;
	height: 2rem;
	margin-top: 1rem;
}
div.upload-btn_wrap input.input_file {
	/*파일찾기 폼 투명하게*/
	position: absolute;
	top: 0;
	right: 0;
	@include scale(width, 75px);
	opacity: 0;
	filter: alpha(opacity=0);
	-ms-filter: 'alpha(opacity=0)';
	-moz-opacity: 0;
	margin-top: 0.6rem;
	&:hover {
		cursor: pointer;
	}
}
div.upload-btn_wrap {
	position: relative;
	display: flex;
	align-items: center;
	width: 100%;
	height: 2rem;
	border-top: 1px solid #bbb;
	padding-left: 3px;
	margin-top: 1rem;
}
div.upload-btn_wrap button {
	@include scale(width, 70px);
	height: 2rem;
	font-weight: bold;
	background: rgb(225, 225, 225);
	border: none;
	border-radius: 3px;
	color: rgb(150, 149, 149);
	margin-top: 1rem;
}
</style>
