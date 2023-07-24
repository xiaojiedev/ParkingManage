// 停车场相关接口

const parkUrl = baseURL + "park/";

console.info(baseURL)

/**
 *
 * @type {string}
 */
const getListUrl = parkUrl + "getList";


/**
 * 保存
 * @type {string}
 */
const saveUrl = parkUrl + "save";

/**
 * 删除
 * @type {string}
 */
const deleteUrl = parkUrl + "delete/";

/**
 * 更新
 * @type {string}
 */
const updateUrl = parkUrl + "put";
