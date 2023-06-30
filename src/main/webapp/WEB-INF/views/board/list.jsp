<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
    <h2>게시판</h2>
    <table class="board">
        <colgroup>
            <col style="width: 10%">
            <col style="">
            <col style="width: 15%">
            <col style="width: 10%">
            <col style="">
        </colgroup>
        <tbody>
            <tr>
                <td colspan="2" class="alglft">
                    <select>
                        <option>제목</option>
                        <option>작성자</option>
                        <option>본 문</option>
                    </select>

                    <input type="text">
                </td>
                <td colspan="3" class="btnrgt">
                    <button type="button" class="btn btn-dark">검색하기</button>
                    <button type="button" id="newbtn" class="btn btn-success">새글쓰기</button>
                </td>
                <!--<td></td>-->
                <!--<td></td>-->
            </tr>

            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td><a href="/board/view?bno=">ㅁㄴㅇㅁㄴㅇ</a></td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr>
                <td>1</td>
                <td>ㅁㄴㅇㅁㄴㅇ</td>
                <td>abc123</td>
                <td>2023-07-21</td>
                <td>987</td>
            </tr>



        </tbody>
    </table>
    <ul class="pagenation">
        <li>이전</li>
        <li><a href="?cpg" class="cpage">1</a></li>
        <li><a href="?cpg">2</a></li>
        <li><a href="?cpg">3</a></li>
        <li><a href="?cpg">4</a></li>
        <li><a href="?cpg">5</a></li>
        <li><a href="?cpg">6</a></li>
        <li><a href="?cpg">7</a></li>
        <li><a href="?cpg">8</a></li>
        <li><a href="?cpg">9</a></li>
        <li><a href="?cpg">10</a></li>
        <li>다음</li>
    </ul>

</main>

<script src="/assets/js/board.js"></script>